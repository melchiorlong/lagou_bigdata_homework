package com.homework.Stage1.Section2.Topic3.BasicInfo;

import com.homework.Stage1.Section2.Topic3.BasicInfo.SimCard;
import com.homework.Stage1.Section2.Topic3.CallingSerInterface;

public class CallPlans implements CallingSerInterface {

    private String CallingDuration;
    private int MsgNum;
    private int Price;

    public CallPlans() {
    }

    public CallPlans(String callingDuration, int msgNum, int price) {
        CallingDuration = callingDuration;
        MsgNum = msgNum;
        Price = price;
    }

    public String getCallingDuration() {
        return CallingDuration;
    }

    public void setCallingDuration(String callingDuration) {
        CallingDuration = callingDuration;
    }

    public int getMsgNum() {
        return MsgNum;
    }

    public void setMsgNum(int msgNum) {
        MsgNum = msgNum;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void callPlanShow(){
        System.out.println("套餐信息如下：");
        System.out.println("通话时长：" + getCallingDuration());
        System.out.println("短信条数：" + getMsgNum());
        System.out.println("每月资费：" + getPrice());
    }

    @Override
    public void callingSevShow(int CallingDuration, SimCard simCard) {

    }
}
