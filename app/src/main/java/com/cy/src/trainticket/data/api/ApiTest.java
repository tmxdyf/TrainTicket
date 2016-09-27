package com.cy.src.trainticket.data.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.cy.src.entity.TicketModel;
import com.cy.src.trainticket.R;
import com.cy.src.trainticket.data.info.Station;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by CY on 2016/9/26.
 */
public class ApiTest {

    public static void main(String[] args) {
//        Observable<TicketModel> observable = RequestHelper.getApiService().getTicket("2016-9-30", "SZQ", "WHN");
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

//        queryNextTicket("2016-9-30");
    }


}
