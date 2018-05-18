package com.dhsoft.alfo6_20.hospital;

import android.text.Editable;

/**
 * Created by alfo6-20 on 2018-05-08.
 */

public class Item {

    String dutyName;
    String dutyAddr;
    String dutyTel1;
    String msg;


    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {

        return msg;
    }

    public String getDutyName() {
        return dutyName;
    }

    public String getDutyAddr() {
        return dutyAddr;
    }

    public String getDutyTel1() {
        return dutyTel1;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public void setDutyAddr(String dutyAddr) {
        this.dutyAddr = dutyAddr;
    }

    public void setDutyTel1(String dutyTel1) {
        this.dutyTel1 = dutyTel1;
    }
}
