package com.cy.src.trainticket.data.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by CY on 2016/9/26.
 */

public class RequestHelper {

    //    https://github.com/tmxdyf/widuu

//    获取余票信息
//    http://kyfw.12306.cn/otn/lcxxcx/query?purpose_codes=ADULT&queryDate=$date&from_station=$startstaion&to_station=$endstation

//    获取价格信息
//    http://kyfw.12306.cn/otn/leftTicket/queryTicketPrice?train_no=".$data[$key]["train_no"]."&from_station_no=".$data[$key]["from_station_no"]."&to_station_no=".$data[$key]["to_station_no"]."&seat_types=".$data[$key]["seat_types"]."&train_date=$date

//    获取车票最佳路线
//    A->B
//    A->.............->B

    private static ApiService mApiService;

    static {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://kyfw.12306.cn")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        mApiService = retrofit.create(ApiService.class);
    }

    public static ApiService getApiService() {
        return mApiService;
    }
}
