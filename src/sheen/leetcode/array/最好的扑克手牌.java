package sheen.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 最好的扑克手牌
 * @Date 2023/2/20 12:04 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最好的扑克手牌 {
    public String bestHand(int[] ranks, char[] suits) {
        int count = 0;
        for(int i = 0; i < suits.length; i++) {
            if(suits[i] == suits[0]) {
                count++;
            }
        }

        if(count == 5) {
            return "Flush";
        }

        Arrays.sort(ranks);

        boolean flag = false;
        for(int i = 0; i < ranks.length - 1; i++) {
            if(ranks[i] == ranks[i + 1]) {
                flag = true;
            }
        }

        if(flag == true) {
            for(int i = 0; i < ranks.length - 2; i++) {
                if(ranks[i] == ranks[i + 2]) {
                    return "Three of a Kind";
                }
            }

            return "Pair";
        }




        return "High Card";


    }
}
