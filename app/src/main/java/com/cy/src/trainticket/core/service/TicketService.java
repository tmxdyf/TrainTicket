package com.cy.src.trainticket.core.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;

import com.cy.src.entity.TicketModel;
import com.cy.src.trainticket.R;
import com.cy.src.trainticket.data.api.RequestHelper;
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
 * @author CY
 * @since 2016-9-23
 */
public class TicketService extends Service {

    public TicketService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }



//路线计算 方案一
//    A->Z
//    A->B->Z
//    A->B->A->Z
//    A->B->A->A->Z
//    A->B->A->B->Z
//    ....
//    A->B->B->Z
//    A->B->B->A->Z
//    A->B->B->B->Z
//    ....
//    A->B->C->Z
//    A->B->C->A->Z
//    A->B->C->B->Z
//    ....

//    A->Y->Z
//    A->Y->A->Z
//    A->Y->A->A->Z
//    A->Y->A->B->Z
//    A->Y->A->C->Z
//    A->Z

// 路线计算 方案二
//    A->Z
//    A->A->Z
//    A->B->Z
//    A->C->Z
//    A->D->Z
//    ....
//    A->Y->Z

//    ....
//    A->A->A->Z
//    A->A->B->Z
//    A->A->C->Z
//    ....
//    A->A->Y->Z
//    ....
//    A->B->A->Z
//    A->B->B->Z
//    A->B->C->Z
//    A->B->D->Z
//    ....
//    A->B->Y->Z


}
