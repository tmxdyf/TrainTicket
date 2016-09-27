package com.cy.src.trainticket;

import android.app.Application;

import com.cy.src.trainticket.data.dao.DaoHelper;
import com.facebook.stetho.Stetho;

/**
 * Created by CY on 2016/9/27.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        DaoHelper.getInstance().init(this, "ticket");
    }
}
