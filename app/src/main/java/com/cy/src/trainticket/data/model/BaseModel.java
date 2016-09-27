package com.cy.src.trainticket.data.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by CY on 2016/9/26.
 */

public class BaseModel<T> {

    public String validateMessagesShowId;// "_validatorMessage",
    public boolean status;// true,
    public int httpstatus;// 200,
    public Data<T> data;
    public JsonArray messages;
    public JsonObject validateMessages;

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

    public JsonArray getMessages() {
        return messages;
    }

    public JsonObject getValidateMessages() {
        return validateMessages;
    }


    public static class Data<T> {
        boolean flag;//true,
        String searchDate;//": "2016年09月30号&nbsp;&nbsp;周五"
        List<T> datas;

        public boolean isFlag() {
            return flag;
        }

        public String getSearchDate() {
            return searchDate;
        }

        public List<T> getDatas() {
            return datas;
        }
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "validateMessagesShowId='" + validateMessagesShowId + '\'' +
                ", status=" + status +
                ", httpstatus=" + httpstatus +
                ", data=" + data +
                ", messages=" + messages +
                ", validateMessages=" + validateMessages +
                '}';
    }
}
