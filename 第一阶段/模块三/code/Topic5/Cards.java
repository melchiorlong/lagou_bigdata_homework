package com.homework.Stage1.Section3.Topic5;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Cards {

//    private static final String[] suit = new String[]{"Spade", "Heart", "Club", "Diamond"};
    private static final String[] jokers = new String[]{"大王", "小王"};
    private static final String[] suits = new String[]{"黑桃", "红桃", "梅花", "方片"};
    private static final String[] nums = new String[]{"2","A","K", "Q", "J","10","9","8","7","6","5","4","3"};

    public Cards() {
    }

    public static String[] getSuits() {
        return suits;
    }

    public static String[] getNums() {
        return nums;
    }

    public static String[] getJokers() {
        return jokers;
    }
}
