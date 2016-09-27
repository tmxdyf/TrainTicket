package com.cy.src.trainticket.data.api;

import com.cy.src.trainticket.data.model.TicketModelList;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cy on 16-9-23.
 */

public interface ApiService {


    /**
     * 获取余票信息
     *
     * @param date        日期，例如：2016-01-01
     * @param startstaion 起始站 编码
     * @param endstation  终点站 编码
     * @return
     */
    @GET("/otn/lcxxcx/query?purpose_codes=ADULT")//&queryDate=/{date}/&from_station=/{startstaion}/&to_station=/{endstation}/
    Observable<TicketModelList> getTicket(@Query("queryDate") String date, @Query("from_station") String startstaion, @Query("to_station") String endstation);

}
