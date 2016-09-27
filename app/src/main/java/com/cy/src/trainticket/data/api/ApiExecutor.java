package com.cy.src.trainticket.data.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.cy.src.entity.TicketModel;
import com.cy.src.trainticket.R;
import com.cy.src.trainticket.data.dao.DaoHelper;
import com.cy.src.trainticket.data.info.Station;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by CY on 2016/9/27.
 */

public class ApiExecutor {


    public Observable<TicketModel> queryNextTicket(String date, Context context, String startStation) {

//        Observable<TicketModel> observable = RequestHelper.getApiService().getTicket(date, "SZQ", "WHN");
//        observable.subscribeOn(Schedulers.newThread()).subscribe(new Action1<TicketModel>() {
//            @Override
//            public void call(TicketModel o) {
//                System.out.println("o=" + o);
//            }
//        }, new Action1<Throwable>() {
//            @Override
//            public void call(Throwable throwable) {
//                throwable.printStackTrace();
//            }
//        });


        List<Station> list = new ArrayList<>();
        try {
            InputStream inputStream = context.getResources().getAssets().open("station");
            String station = IOUtils.toString(inputStream);
            String[] split = station.split(",");
            for (String s : split) {
                System.out.println(s);
                String[] sp = s.split("-");
                list.add(new Station(sp[0], sp[1]));
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return Observable.from(list)
                .flatMap(s ->
                        query(context, date, startStation, s.getValue())//"SZQ"
                )
                .doOnNext(ticketModel ->
                        DaoHelper.getInstance().getDaoSession().getTicketModelDao().insert(ticketModel)
                )
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());

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
