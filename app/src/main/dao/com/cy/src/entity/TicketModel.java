package com.cy.src.entity;

import com.cy.src.trainticket.data.model.BaseModel;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by CY on 2016/9/26.
 */

@Entity(nameInDb = "ticket")
public class TicketModel extends BaseModel<TicketModel> {

    public String train_no;// "6i000G100209",
    public String station_train_code;// "G1002",
    public String start_station_telecode;// "IOQ",
    public String start_station_name;// "深圳北",
    public String end_station_telecode;// "WHN",
    public String end_station_name;// "武汉",
    public String from_station_telecode;// "IOQ",
    public String from_station_name;// "深圳北",
    public String to_station_telecode;// "WHN",
    public String to_station_name;// "武汉",
    public String start_time;// "07:00",
    public String arrive_time;// "11:38",
    public String day_difference;// "0",
    public String train_class_name;// "",
    public String lishi;// "04:38",
    public String canWebBuy;// "N",
    public String lishiValue;// "278",
    public String yp_info;// "O0538000009165800000O053803000M083800000",
    public String control_train_day;// "20991231",
    public String start_train_date;// "20160930",
    public String seat_feature;// "O393M3W3",
    public String yp_ex;// "O090O0M0",
    public String train_seat_feature;// "3",
    public String seat_types;// "O9OM",
    public String location_code;// "Q6",
    public String from_station_no;// "01",
    public String to_station_no;// "07",
    public int control_day;// 59,
    public String sale_time;// "0900",
    public String is_support_card;// "1",
    public String note;// "",
    public String gg_num;// "--",
    public String gr_num;// "--",
    public String qt_num;// "--",
    public String rw_num;// "--",
    public String rz_num;// "--",
    public String tz_num;// "--",
    public String wz_num;// "无",
    public String yb_num;// "--",
    public String yw_num;// "--",
    public String yz_num;// "--",
    public String ze_num;// "无",
    public String zy_num;// "无",
    public String swz_num;// "无"

    @Generated(hash = 113893902)
    public TicketModel(String train_no, String station_train_code,
            String start_station_telecode, String start_station_name,
            String end_station_telecode, String end_station_name,
            String from_station_telecode, String from_station_name,
            String to_station_telecode, String to_station_name, String start_time,
            String arrive_time, String day_difference, String train_class_name,
            String lishi, String canWebBuy, String lishiValue, String yp_info,
            String control_train_day, String start_train_date, String seat_feature,
            String yp_ex, String train_seat_feature, String seat_types,
            String location_code, String from_station_no, String to_station_no,
            int control_day, String sale_time, String is_support_card, String note,
            String gg_num, String gr_num, String qt_num, String rw_num,
            String rz_num, String tz_num, String wz_num, String yb_num,
            String yw_num, String yz_num, String ze_num, String zy_num,
            String swz_num) {
        this.train_no = train_no;
        this.station_train_code = station_train_code;
        this.start_station_telecode = start_station_telecode;
        this.start_station_name = start_station_name;
        this.end_station_telecode = end_station_telecode;
        this.end_station_name = end_station_name;
        this.from_station_telecode = from_station_telecode;
        this.from_station_name = from_station_name;
        this.to_station_telecode = to_station_telecode;
        this.to_station_name = to_station_name;
        this.start_time = start_time;
        this.arrive_time = arrive_time;
        this.day_difference = day_difference;
        this.train_class_name = train_class_name;
        this.lishi = lishi;
        this.canWebBuy = canWebBuy;
        this.lishiValue = lishiValue;
        this.yp_info = yp_info;
        this.control_train_day = control_train_day;
        this.start_train_date = start_train_date;
        this.seat_feature = seat_feature;
        this.yp_ex = yp_ex;
        this.train_seat_feature = train_seat_feature;
        this.seat_types = seat_types;
        this.location_code = location_code;
        this.from_station_no = from_station_no;
        this.to_station_no = to_station_no;
        this.control_day = control_day;
        this.sale_time = sale_time;
        this.is_support_card = is_support_card;
        this.note = note;
        this.gg_num = gg_num;
        this.gr_num = gr_num;
        this.qt_num = qt_num;
        this.rw_num = rw_num;
        this.rz_num = rz_num;
        this.tz_num = tz_num;
        this.wz_num = wz_num;
        this.yb_num = yb_num;
        this.yw_num = yw_num;
        this.yz_num = yz_num;
        this.ze_num = ze_num;
        this.zy_num = zy_num;
        this.swz_num = swz_num;
    }

    @Generated(hash = 1241234460)
    public TicketModel() {
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
     *   ["swz_num"]=> 商务座
     */


    public String getTrain_no() {
        return train_no;
    }

    public void setTrain_no(String train_no) {
        this.train_no = train_no;
    }

    public String getStation_train_code() {
        return station_train_code;
    }

    public void setStation_train_code(String station_train_code) {
        this.station_train_code = station_train_code;
    }

    public String getStart_station_telecode() {
        return start_station_telecode;
    }

    public void setStart_station_telecode(String start_station_telecode) {
        this.start_station_telecode = start_station_telecode;
    }

    public String getStart_station_name() {
        return start_station_name;
    }

    public void setStart_station_name(String start_station_name) {
        this.start_station_name = start_station_name;
    }

    public String getEnd_station_telecode() {
        return end_station_telecode;
    }

    public void setEnd_station_telecode(String end_station_telecode) {
        this.end_station_telecode = end_station_telecode;
    }

    public String getEnd_station_name() {
        return end_station_name;
    }

    public void setEnd_station_name(String end_station_name) {
        this.end_station_name = end_station_name;
    }

    public String getFrom_station_telecode() {
        return from_station_telecode;
    }

    public void setFrom_station_telecode(String from_station_telecode) {
        this.from_station_telecode = from_station_telecode;
    }

    public String getFrom_station_name() {
        return from_station_name;
    }

    public void setFrom_station_name(String from_station_name) {
        this.from_station_name = from_station_name;
    }

    public String getTo_station_telecode() {
        return to_station_telecode;
    }

    public void setTo_station_telecode(String to_station_telecode) {
        this.to_station_telecode = to_station_telecode;
    }

    public String getTo_station_name() {
        return to_station_name;
    }

    public void setTo_station_name(String to_station_name) {
        this.to_station_name = to_station_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getArrive_time() {
        return arrive_time;
    }

    public void setArrive_time(String arrive_time) {
        this.arrive_time = arrive_time;
    }

    public String getDay_difference() {
        return day_difference;
    }

    public void setDay_difference(String day_difference) {
        this.day_difference = day_difference;
    }

    public String getTrain_class_name() {
        return train_class_name;
    }

    public void setTrain_class_name(String train_class_name) {
        this.train_class_name = train_class_name;
    }

    public String getLishi() {
        return lishi;
    }

    public void setLishi(String lishi) {
        this.lishi = lishi;
    }

    public String getCanWebBuy() {
        return canWebBuy;
    }

    public void setCanWebBuy(String canWebBuy) {
        this.canWebBuy = canWebBuy;
    }

    public String getLishiValue() {
        return lishiValue;
    }

    public void setLishiValue(String lishiValue) {
        this.lishiValue = lishiValue;
    }

    public String getYp_info() {
        return yp_info;
    }

    public void setYp_info(String yp_info) {
        this.yp_info = yp_info;
    }

    public String getControl_train_day() {
        return control_train_day;
    }

    public void setControl_train_day(String control_train_day) {
        this.control_train_day = control_train_day;
    }

    public String getStart_train_date() {
        return start_train_date;
    }

    public void setStart_train_date(String start_train_date) {
        this.start_train_date = start_train_date;
    }

    public String getSeat_feature() {
        return seat_feature;
    }

    public void setSeat_feature(String seat_feature) {
        this.seat_feature = seat_feature;
    }

    public String getYp_ex() {
        return yp_ex;
    }

    public void setYp_ex(String yp_ex) {
        this.yp_ex = yp_ex;
    }

    public String getTrain_seat_feature() {
        return train_seat_feature;
    }

    public void setTrain_seat_feature(String train_seat_feature) {
        this.train_seat_feature = train_seat_feature;
    }

    public String getSeat_types() {
        return seat_types;
    }

    public void setSeat_types(String seat_types) {
        this.seat_types = seat_types;
    }

    public String getLocation_code() {
        return location_code;
    }

    public void setLocation_code(String location_code) {
        this.location_code = location_code;
    }

    public String getFrom_station_no() {
        return from_station_no;
    }

    public void setFrom_station_no(String from_station_no) {
        this.from_station_no = from_station_no;
    }

    public String getTo_station_no() {
        return to_station_no;
    }

    public void setTo_station_no(String to_station_no) {
        this.to_station_no = to_station_no;
    }

    public int getControl_day() {
        return control_day;
    }

    public void setControl_day(int control_day) {
        this.control_day = control_day;
    }

    public String getSale_time() {
        return sale_time;
    }

    public void setSale_time(String sale_time) {
        this.sale_time = sale_time;
    }

    public String getIs_support_card() {
        return is_support_card;
    }

    public void setIs_support_card(String is_support_card) {
        this.is_support_card = is_support_card;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getGg_num() {
        return gg_num;
    }

    public void setGg_num(String gg_num) {
        this.gg_num = gg_num;
    }

    public String getGr_num() {
        return gr_num;
    }

    public void setGr_num(String gr_num) {
        this.gr_num = gr_num;
    }

    public String getQt_num() {
        return qt_num;
    }

    public void setQt_num(String qt_num) {
        this.qt_num = qt_num;
    }

    public String getRw_num() {
        return rw_num;
    }

    public void setRw_num(String rw_num) {
        this.rw_num = rw_num;
    }

    public String getRz_num() {
        return rz_num;
    }

    public void setRz_num(String rz_num) {
        this.rz_num = rz_num;
    }

    public String getTz_num() {
        return tz_num;
    }

    public void setTz_num(String tz_num) {
        this.tz_num = tz_num;
    }

    public String getWz_num() {
        return wz_num;
    }

    public void setWz_num(String wz_num) {
        this.wz_num = wz_num;
    }

    public String getYb_num() {
        return yb_num;
    }

    public void setYb_num(String yb_num) {
        this.yb_num = yb_num;
    }

    public String getYw_num() {
        return yw_num;
    }

    public void setYw_num(String yw_num) {
        this.yw_num = yw_num;
    }

    public String getYz_num() {
        return yz_num;
    }

    public void setYz_num(String yz_num) {
        this.yz_num = yz_num;
    }

    public String getZe_num() {
        return ze_num;
    }

    public void setZe_num(String ze_num) {
        this.ze_num = ze_num;
    }

    public String getZy_num() {
        return zy_num;
    }

    public void setZy_num(String zy_num) {
        this.zy_num = zy_num;
    }

    public String getSwz_num() {
        return swz_num;
    }

    public void setSwz_num(String swz_num) {
        this.swz_num = swz_num;
    }

    @Override
    public String toString() {
        return "TicketModel{" +
                "train_no='" + train_no + '\'' +
                ", station_train_code='" + station_train_code + '\'' +
                ", start_station_telecode='" + start_station_telecode + '\'' +
                ", start_station_name='" + start_station_name + '\'' +
                ", end_station_telecode='" + end_station_telecode + '\'' +
                ", end_station_name='" + end_station_name + '\'' +
                ", from_station_telecode='" + from_station_telecode + '\'' +
                ", from_station_name='" + from_station_name + '\'' +
                ", to_station_telecode='" + to_station_telecode + '\'' +
                ", to_station_name='" + to_station_name + '\'' +
                ", start_time='" + start_time + '\'' +
                ", arrive_time='" + arrive_time + '\'' +
                ", day_difference='" + day_difference + '\'' +
                ", train_class_name='" + train_class_name + '\'' +
                ", lishi='" + lishi + '\'' +
                ", canWebBuy='" + canWebBuy + '\'' +
                ", lishiValue='" + lishiValue + '\'' +
                ", yp_info='" + yp_info + '\'' +
                ", control_train_day='" + control_train_day + '\'' +
                ", start_train_date='" + start_train_date + '\'' +
                ", seat_feature='" + seat_feature + '\'' +
                ", yp_ex='" + yp_ex + '\'' +
                ", train_seat_feature='" + train_seat_feature + '\'' +
                ", seat_types='" + seat_types + '\'' +
                ", location_code='" + location_code + '\'' +
                ", from_station_no='" + from_station_no + '\'' +
                ", to_station_no='" + to_station_no + '\'' +
                ", control_day=" + control_day +
                ", sale_time='" + sale_time + '\'' +
                ", is_support_card='" + is_support_card + '\'' +
                ", note='" + note + '\'' +
                ", gg_num='" + gg_num + '\'' +
                ", gr_num='" + gr_num + '\'' +
                ", qt_num='" + qt_num + '\'' +
                ", rw_num='" + rw_num + '\'' +
                ", rz_num='" + rz_num + '\'' +
                ", tz_num='" + tz_num + '\'' +
                ", wz_num='" + wz_num + '\'' +
                ", yb_num='" + yb_num + '\'' +
                ", yw_num='" + yw_num + '\'' +
                ", yz_num='" + yz_num + '\'' +
                ", ze_num='" + ze_num + '\'' +
                ", zy_num='" + zy_num + '\'' +
                ", swz_num='" + swz_num + '\'' +
                '}';
    }

    //    {
//        "validateMessagesShowId": "_validatorMessage",
//            "status": true,
//            "httpstatus": 200,
//            "data": {
//        "datas": [
//        {
//            "train_no": "6i000G100209",
//                "station_train_code": "G1002",
//                "start_station_telecode": "IOQ",
//                "start_station_name": "深圳北",
//                "end_station_telecode": "WHN",
//                "end_station_name": "武汉",
//                "from_station_telecode": "IOQ",
//                "from_station_name": "深圳北",
//                "to_station_telecode": "WHN",
//                "to_station_name": "武汉",
//                "start_time": "07:00",
//                "arrive_time": "11:38",
//                "day_difference": "0",
//                "train_class_name": "",
//                "lishi": "04:38",
//                "canWebBuy": "N",
//                "lishiValue": "278",
//                "yp_info": "O0538000009165800000O053803000M083800000",
//                "control_train_day": "20991231",
//                "start_train_date": "20160930",
//                "seat_feature": "O393M3W3",
//                "yp_ex": "O090O0M0",
//                "train_seat_feature": "3",
//                "seat_types": "O9OM",
//                "location_code": "Q6",
//                "from_station_no": "01",
//                "to_station_no": "07",
//                "control_day": 59,
//                "sale_time": "0900",
//                "is_support_card": "1",
//                "note": "",
//                "gg_num": "--",
//                "gr_num": "--",
//                "qt_num": "--",
//                "rw_num": "--",
//                "rz_num": "--",
//                "tz_num": "--",
//                "wz_num": "无",
//                "yb_num": "--",
//                "yw_num": "--",
//                "yz_num": "--",
//                "ze_num": "无",
//                "zy_num": "无",
//                "swz_num": "无"
//        },
//        {
//            "train_no": "6i000G131202",
//                "station_train_code": "G1312",
//                "start_station_telecode": "IOQ",
//                "start_station_name": "深圳北",
//                "end_station_telecode": "CUW",
//                "end_station_name": "重庆北",
//                "from_station_telecode": "IOQ",
//                "from_station_name": "深圳北",
//                "to_station_telecode": "WHN",
//                "to_station_name": "武汉",
//                "start_time": "07:37",
//                "arrive_time": "12:19",
//                "day_difference": "0",
//                "train_class_name": "",
//                "lishi": "04:42",
//                "canWebBuy": "N",
//                "lishiValue": "282",
//                "yp_info": "O053800000M0838000009165800000",
//                "control_train_day": "20991231",
//                "start_train_date": "20160930",
//                "seat_feature": "O3M393",
//                "yp_ex": "O0M090",
//                "train_seat_feature": "3",
//                "seat_types": "OM9",
//                "location_code": "Q7",
//                "from_station_no": "01",
//                "to_station_no": "07",
//                "control_day": 59,
//                "sale_time": "0900",
//                "is_support_card": "1",
//                "note": "",
//                "gg_num": "--",
//                "gr_num": "--",
//                "qt_num": "--",
//                "rw_num": "--",
//                "rz_num": "--",
//                "tz_num": "--",
//                "wz_num": "--",
//                "yb_num": "--",
//                "yw_num": "--",
//                "yz_num": "--",
//                "ze_num": "无",
//                "zy_num": "无",
//                "swz_num": "无"
//        },
//        {
//            "train_no": "6i0000G28003",
//                "station_train_code": "G280",
//                "start_station_telecode": "IOQ",
//                "start_station_name": "深圳北",
//                "end_station_telecode": "JGK",
//                "end_station_name": "济南西",
//                "from_station_telecode": "IOQ",
//                "from_station_name": "深圳北",
//                "to_station_telecode": "WHN",
//                "to_station_name": "武汉",
//                "start_time": "07:43",
//                "arrive_time": "12:28",
//                "day_difference": "0",
//                "train_class_name": "",
//                "lishi": "04:45",
//                "canWebBuy": "N",
//                "lishiValue": "285",
//                "yp_info": "O0538000009165800000M083800000",
//                "control_train_day": "20991231",
//                "start_train_date": "20160930",
//                "seat_feature": "O3M393",
//                "yp_ex": "O090M0",
//                "train_seat_feature": "3",
//                "seat_types": "O9M",
//                "location_code": "Q6",
//                "from_station_no": "01",
//                "to_station_no": "08",
//                "control_day": 59,
//                "sale_time": "0900",
//                "is_support_card": "1",
//                "note": "",
//                "gg_num": "--",
//                "gr_num": "--",
//                "qt_num": "--",
//                "rw_num": "--",
//                "rz_num": "--",
//                "tz_num": "--",
//                "wz_num": "--",
//                "yb_num": "--",
//                "yw_num": "--",
//                "yz_num": "--",
//                "ze_num": "无",
//                "zy_num": "无",
//                "swz_num": "无"
//        }
//
//        ],
//        "flag": true,
//                "searchDate": "2016年09月30号&nbsp;&nbsp;周五"
//    },
//        "messages": [],
//        "validateMessages": {}
//    }
}
