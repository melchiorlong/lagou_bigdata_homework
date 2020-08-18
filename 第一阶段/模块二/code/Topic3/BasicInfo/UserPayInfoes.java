package com.homework.Stage1.Section2.Topic3.BasicInfo;

public class UserPayInfoes {

    private int CallingDurSum;
    private int NetworkFlowSum;
    private int PricePerMonth;

    public UserPayInfoes() {
    }

    public UserPayInfoes(int callingDurSum, int networkFlowSum, int pricePerMonth) {
        CallingDurSum = callingDurSum;
        NetworkFlowSum = networkFlowSum;
        PricePerMonth = pricePerMonth;
    }

    public int getCallingDurSum() {
        return CallingDurSum;
    }

    public void setCallingDurSum(int callingDurSum) {
        CallingDurSum = callingDurSum;
    }

    public int getNetworkFlowSum() {
        return NetworkFlowSum;
    }

    public void setNetworkFlowSum(int networkFlowSum) {
        NetworkFlowSum = networkFlowSum;
    }

    public int getPricePerMonth() {
        return PricePerMonth;
    }

    public void setPricePerMonth(int pricePerMonth) {
        PricePerMonth = pricePerMonth;
    }
}
