package com.cy.src.trainticket.data.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.cy.src.entity.TicketModel;
import com.cy.src.trainticket.R;
import com.cy.src.trainticket.data.info.Station;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static com.cy.src.trainticket.StationUtils.loadStation;


/**
 * Created by CY on 2016/9/27.
 */

public class ApiExecutor {


    public void queryNextTicket(String date, Context context, String startStation, Subscriber<TicketModel> subscriber) {
        Observable<List<Station>> observable = loadStation(context);

//        平分成8份或者9份，开8,9个线程执行
        observable.map(stations -> {

            List<List<Station>> allList = new ArrayList<>();
            int value = stations.size() / 8;

            for (int i = 0; i < 8; i++) {

                int fromIndex = i * value;
                int toIndex = (i + 1) * value;
                List<Station> subList = stations.subList(fromIndex, toIndex);
                allList.add(subList);
            }

            if (stations.size() % 8 != 0) {
                List<Station> subList = stations.subList(value * 8, stations.size());
                allList.add(subList);
            }
            return allList;
        }).subscribe(lists -> {

            for (List<Station> l : lists) {
                Log.e("TAG", "============size=" + lists.size());
                Observable.from(l).flatMap(station -> query(context, date, startStation, station.getValue())).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<TicketModel>() {
                    @Override
                    public void onCompleted() {
                        Log.e("TAG", "============onCompleted=");
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(TicketModel ticketModel) {

                    }
                });
            }

        }, Throwable::printStackTrace);

//         loadStation(context)
//                .flatMap(new Func1<List<Station>, Observable<TicketModel>>() {
//                    @Override
//                    public Observable<TicketModel> call(List<Station> stations) {
//
//                        return null;
//                    }
//                })
//                .doOnNext(ticketModel ->
//                        DaoHelper.getInstance().getDaoSession().getTicketModelDao().insert(ticketModel)
//                )
//                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());

    }

    public void queryAll(Context context, String date, String startStation, Subscriber<TicketModel> subscriber) {


        Observable<List<Station>> observable = loadStation(context);
        observable.subscribe(stations -> {
            for (Station station : stations) {
                query(context, date, startStation, station.getValue())
                        .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<TicketModel>() {
                            @Override
                            public void call(TicketModel ticketModel) {
                                Log.e("TAG", "============ticketModel=" + ticketModel);
                            }
                        }, Throwable::printStackTrace);
            }

        }, Throwable::printStackTrace);
    }

    /**
     * 执行查询
     *
     * @param context
     * @param date
     * @param startStation
     * @param endStation
     * @return
     */
    public Observable<TicketModel> query(Context context, String date, String startStation, String endStation) {
        return RequestHelper.getApiService()
                .getTicket(date, startStation, endStation)//"WHN"
//                过滤没有车次的
                .filter(baseModel -> baseModel.getData().getDatas() != null && !baseModel.getData().getDatas().isEmpty())
                .flatMap(baseModel -> Observable.from(baseModel.getData().getDatas()))
//                过滤席位
                .filter(model -> isHavePosition(model, context));


    }

    /**
     * 是否有位置,条件过滤
     *
     * @param model
     * @param context
     * @return
     */
    private boolean isHavePosition(TicketModel model, Context context) {
        if (model == null) {
            return false;
        }


    /*
     *   ["gr_num"]=>高级软卧
     *   ["qt_num"]=>其他
     *   ["rw_num"]=> 软卧
     *   ["rz_num"]=>软座
     *   ["tz_num"]=>特等座
     *   ["wz_num"]=>无座
     *   ["yw_num"]=>硬卧
     *   ["yz_num"]=>硬座
     *   ["ze_num"]=>二等座
     *   ["zy_num"]=> 一等座
     *   ["swz_num"]=> 商务座 无
     */


        String positions[] = {model.yz_num, model.yw_num, model.wz_num, model.ze_num};


        for (int i = 0; i < positions.length; i++) {
            boolean isHave = isHavePosition(positions[i], context);
            if (isHave) {
                return true;
            }
        }
        Log.e("ApiTest", "havenot ticket " + model);
        return false;
    }

    private boolean isHavePosition(String position, Context context) {
        if (TextUtils.isEmpty(position)) {
            return false;
        }
        String compares[] = context.getResources().getStringArray(R.array.compares);
        for (int j = 0; j < compares.length; j++) {
            if (compares[j].equals(position)) {

                return false;
            }
        }
        Log.e("ApiTest", "isHavePosition  " + position);
        return true;
    }

}
