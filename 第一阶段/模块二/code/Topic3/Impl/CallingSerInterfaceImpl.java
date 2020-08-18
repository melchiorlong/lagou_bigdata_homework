package com.homework.Stage1.Section2.Topic3.Impl;

import com.homework.Stage1.Section2.Topic3.AbstractPlans;
import com.homework.Stage1.Section2.Topic3.BasicInfo.SimCard;
import com.homework.Stage1.Section2.Topic3.CallingSerInterface;

public class CallingSerInterfaceImpl implements CallingSerInterface {
    public CallingSerInterfaceImpl(int callingDuration, SimCard simCard) {
    }

    @Override
    public void callingSevShow(int CallingDuration, SimCard simCard) {
        System.out.println("接口实现通话时长" + CallingDuration);
    }

}
