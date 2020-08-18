package com.homework.Stage1.Section2.Topic3.BasicInfo;

import com.homework.Stage1.Section2.Topic3.BasicInfo.SimCard;
import com.homework.Stage1.Section2.Topic3.NetworkSerInterface;

public class NetworkPlans implements NetworkSerInterface {

    private int NetworkFlow;
    private int Price;

    public NetworkPlans() {
    }

    public NetworkPlans(int networkFlow, int price) {
        NetworkFlow = networkFlow;
        Price = price;
    }

    public int getNetworkFlow() {
        return NetworkFlow;
    }

    public void setNetworkFlow(int networkFlow) {
        NetworkFlow = networkFlow;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public void networkPlanShow(){
        System.out.println("套餐信息如下：");
        System.out.println("上网流量：" + getNetworkFlow());
        System.out.println("每月资费：" + getPrice());
    }

    @Override
    public void networkSevShow(int networkFlow, SimCard simCard) {
        System.out.println("接口实现上网流量：" + networkFlow);
    }
}
