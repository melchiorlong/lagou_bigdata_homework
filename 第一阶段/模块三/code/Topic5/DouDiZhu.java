package com.homework.Stage1.Section3.Topic5;

import java.util.*;

public class DouDiZhu {

    /**
     * 使用集合实现斗地主游戏的部分功能，要求如下：
     * （1）首先准备 54 张扑克牌并打乱顺序。
     * （2）由三个玩家交替摸牌，每人 17 张扑克牌，最后三张留作底牌。
     * （3）查看三个玩家手中的扑克牌和底牌。
     * （4）其中玩家手中的扑克牌需要按照大小顺序打印，规则如下：
     * 手中扑克牌从大到小的摆放顺序：大王,小王,2,A,K,Q,J,10,9,8,7,6,5,4,3
     *
     * 解题思路：
     * 1、准备四种花色 Spade, Heart, Club, Diamond
     * 2、准备13张牌
     * 3、插入大小王
     * 4、将花色和数值相乘，得到所有非大小王的牌，按顺序插入Map，此时Map中key的大小代表了牌的大小
     * 5、取出KeySet，然后shuffle洗牌
     * 6、按顺序抓牌，每个玩家17张牌
     * 7、底牌为牌堆中最后3张
     * 8、展示
     *
     */

    public static void main(String[] args) {

//        创建Map，Key代表牌的id，Value代表牌的花色及数值
//        id的顺序及代表牌大小顺序
        HashMap<Integer, String> cards = new HashMap<>();
        String[] jokers = Cards.getJokers();
        String[] suits = Cards.getSuits();
        String[] nums = Cards.getNums();

//        插入大小王
        int count = 0;
        for (String joker : jokers) {
            cards.put(count, joker);
            count += 1;
        }
//        插入剩余52张牌
        for (String num : nums) {
            for (String suit : suits) {
                String suit_num = suit + num;
                cards.put(count, suit_num);
                count += 1;
            }
        }

//        显示准备好的扑克牌
        Set<Map.Entry<Integer, String>> entries = cards.entrySet();
        for (Map.Entry<Integer, String> entry : entries
        ) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

//        洗牌
        Set<Integer> cardsSet = cards.keySet();
        List<Integer> cardsList = new ArrayList<>(cardsSet);
        Collections.shuffle(cardsList);
//        抓牌
        Set<Integer> player1 = new TreeSet<>();
        Set<Integer> player2 = new TreeSet<>();
        Set<Integer> player3 = new TreeSet<>();
        Set<Integer> diPai = new TreeSet<>();
        for (int i = 0; i < 49; i += 3) {
            player1.add(cardsList.get(i));
            player2.add(cardsList.get(i + 1));
            player3.add(cardsList.get(i + 2));
        }
//        插入底牌
        diPai.add(cardsList.get(cardsList.size() - 1));
        diPai.add(cardsList.get(cardsList.size() - 2));
        diPai.add(cardsList.get(cardsList.size() - 3));


//        展示所有牌
        List<String> player1_list = new ArrayList<>();
        List<String> player2_list = new ArrayList<>();
        List<String> player3_list = new ArrayList<>();
        List<String> diPai_list = new ArrayList<>();
        for (Integer i : player1) {
            player1_list.add(cards.get(i));
        }
        for (Integer i : player2) {
            player2_list.add(cards.get(i));
        }
        for (Integer i : player3) {
            player3_list.add(cards.get(i));
        }
        for (Integer i : diPai) {
            diPai_list.add(cards.get(i));
        }

        System.out.println("--------------------------------------------------------------------");

        System.out.println("玩家1的牌是：" + player1_list);
        System.out.println("玩家2的牌是：" + player2_list);
        System.out.println("玩家2的牌是：" + player3_list);
        System.out.println("底牌是：" + diPai_list);

    }
}
