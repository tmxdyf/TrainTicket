package com.cy.src.trainticket.data.api;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by CY on 2016/9/26.
 */

public class ApiTest {

    public static void main(String[] args) {
        Observable observable = RequestHelper.getApiService().getTicket("2016-9-30", "SZQ", "WHN");
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                System.out.println("o=" + o);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
