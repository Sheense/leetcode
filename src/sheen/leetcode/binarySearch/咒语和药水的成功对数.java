package sheen.leetcode.binarySearch;

import java.util.Arrays;

/**
 * @Classname 咒语和药水的成功对数
 * @Date 2023/11/10 00:17
 * @Created by sheen
 * @Description TODO
 */
public class 咒语和药水的成功对数 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for(int i = 0; i < spells.length; i++) {
            int v = search(potions, success, spells[i]);
            res[i] = potions.length - v;
        }
        return res;
    }

    public int search(int[] potions, long success, int v) {
        int left = 0;
        int right = potions.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if((long)potions[mid] * v >= success) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
