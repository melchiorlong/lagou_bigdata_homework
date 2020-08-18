package com.homework.Stage1.Section2.Topic3.BasicInfo;

public enum SimCardTypeEnum {
    BIG("大卡"),
    SMALL("小卡"),
    MICRO("微型卡");

    private final String CardType;

    SimCardTypeEnum(String cardType) {
        this.CardType = cardType;
    }

    public String getCardType() {
        return CardType;
    }
}
