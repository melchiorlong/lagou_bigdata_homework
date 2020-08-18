package com.homework.Stage1.Section2.Topic3;

import com.homework.Stage1.Section2.Topic3.BasicInfo.SimCard;
import com.homework.Stage1.Section2.Topic3.BasicInfo.SimCardTypeEnum;
import com.homework.Stage1.Section2.Topic3.BasicInfo.UserPayInfoes;
import com.homework.Stage1.Section2.Topic3.Impl.CallingSerInterfaceImpl;
import com.homework.Stage1.Section2.Topic3.Impl.NetworkSerInterfaceImpl;

/**
 *
 * 按照要求设计并实现以下实体类和接口。
 *
 *     3.1 第一步：设计和实现以下类
 *
 *     （1）手机卡类 特征：卡类型、卡号、用户名、密码、账户余额、通话时长(分钟)、上网流量 行为：显示（卡号 + 用户名 + 当前余额）
 *
 *     （2）通话套餐类 特征：通话时长、短信条数、每月资费 行为: 显示所有套餐信息     （3）上网套餐类 特征：上网流量、每月资费 行为：显示所有套餐信息
 *
 *     （4）用户消费信息类 特征：统计通话时长、统计上网流量、每月消费金额
 *
 *     3.2 第二步：设计和实现以下枚举类 手机卡的类型总共有 3 种：大卡、小卡、微型卡
 *
 *     3.3 第三步：实体类的优化 将通话套餐类和上网套餐类中相同的特征和行为提取出来组成抽象套餐类。
 *
 *     3.4 第四步：创建并实现以下接口
 *
 *     （1）通话服务接口 抽象方法: 参数1: 通话分钟, 参数2: 手机卡类对象 让通话套餐类实现通话服务接口。
 *
 *     （2）上网服务接口 抽象方法: 参数1: 上网流量, 参数2: 手机卡类对象 让上网套餐类实现上网服务接口。
 *
 * 解题思路：
 * 按照要求写就行，但是多态部分仍理解不够透彻，烦请老师在答疑中能够再讲解下。
 * 谢谢！
 */


public class Test {

    public static void main(String[] args) {

        //初始化用户信息等
        SimCard simCard = new SimCard();
        simCard.setUserName("张三");
        simCard.setPassword("123456");
        simCard.setCardNum("13813333333");
        simCard.setCardType(SimCardTypeEnum.MICRO);
        simCard.setCallingDuration(100);
        simCard.setNetworkFlow(200);
        simCard.setAccountBalance(300.00);
        // 显示
        simCard.simCardShow();
        System.out.println("---------------------------------------------------------------------------");


        // 通过接口实现显示
        CallingSerInterfaceImpl call = new CallingSerInterfaceImpl(simCard.getCallingDuration(), simCard);
        NetworkSerInterfaceImpl network = new NetworkSerInterfaceImpl(simCard.getNetworkFlow(), simCard);

        UserPayInfoes userPayInfoes = new UserPayInfoes();
        userPayInfoes.setCallingDurSum(10);
        userPayInfoes.setNetworkFlowSum(20);
        userPayInfoes.setPricePerMonth(100);

        CallingSerInterface callingSerInterface;
        NetworkSerInterface networkSerInterface;

        callingSerInterface = call;
        networkSerInterface = network;

        callingSerInterface.callingSevShow(userPayInfoes.getCallingDurSum(), simCard);
        networkSerInterface.networkSevShow(userPayInfoes.getNetworkFlowSum(), simCard);



    }



}
