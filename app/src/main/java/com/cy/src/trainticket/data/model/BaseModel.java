package com.cy.src.trainticket.data.model;

import java.sql.Date;
import java.util.List;

/**
 * Created by CY on 2016/9/26.
 */

public class BaseModel<T> {

    String validateMessagesShowId;// "_validatorMessage",
    boolean status;// true,
    int httpstatus;// 200,
    Data<T> data;
    List messages;
    String validateMessages;

    public String getValidateMessagesShowId() {
        return validateMessagesShowId;
    }

    public boolean isStatus() {
        return status;
    }

    public int getHttpstatus() {
        return httpstatus;
    }

    public Data<T> getData() {
        return data;
    }

    public List getMessages() {
        return messages;
    }

    public String getValidateMessages() {
        return validateMessages;
    }


    public class Data<T> {
        boolean flag;//true,
        Date searchDate;//": "2016年09月30号&nbsp;&nbsp;周五"
        List<T> datas;

        public boolean isFlag() {
            return flag;
        }

        public Date getSearchDate() {
            return searchDate;
        }

        public List<T> getDatas() {
            return datas;
        }
    }
}
