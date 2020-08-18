package com.homework.Stage1.Section2.Topic3.Impl;

import com.homework.Stage1.Section2.Topic3.BasicInfo.SimCard;
import com.homework.Stage1.Section2.Topic3.NetworkSerInterface;

public class NetworkSerInterfaceImpl implements NetworkSerInterface {


    public NetworkSerInterfaceImpl(int networkFlow, SimCard simCard) {
    }

    @Override
    public void networkSevShow(int networkFlow, SimCard simCard) {
        System.out.println("接口实现显示上网流量：" + networkFlow);
    }
}
