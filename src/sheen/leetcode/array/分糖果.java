package sheen.leetcode.array;

import java.util.Arrays;

/**
 * @Classname 分糖果
 * @Date 2021/11/1 12:51 上午
 * @Created by sheen
 * @Description TODO
 */
public class 分糖果 {
    public int distributeCandies(int[] candyType) {
        Arrays.sort(candyType);
        int value = candyType[0];
        int type = 1;
        for(int i = 0 ; i < candyType.length; i++) {
            if(value != candyType[i]) {
                type++;
                value = candyType[i];
            }
        }
        return Math.min(candyType.length/2, type);
    }
}
