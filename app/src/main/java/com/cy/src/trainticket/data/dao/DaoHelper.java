package com.cy.src.trainticket.data.dao;

import android.content.Context;

import com.cy.src.entity.DaoMaster;
import com.cy.src.entity.DaoSession;


/**
 * Created by CY on 2016/9/27.
 */

public class DaoHelper {

    private final static DaoHelper mDaoHelper = new DaoHelper();

    private DaoSession mDaoSession;
    private Context mContext;
    private String dbName;

    public static DaoHelper getInstance() {
        return mDaoHelper;
    }


    private DaoHelper() {
    }

    public void init(Context context, String dbName) {
        mContext = context;
        this.dbName = dbName;
    }


    public DaoSession getDaoSession() {
        if (mDaoSession == null) {
            mDaoSession = DaoMaster.newDevSession(mContext, dbName);
        }
        return mDaoSession;
    }

}
