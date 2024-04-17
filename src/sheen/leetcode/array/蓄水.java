package sheen.leetcode.array;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @Classname 蓄水
 * @Date 2023/5/21 10:58 上午
 * @Created by sheen
 * @Description TODO
 */
public class 蓄水 {
    public static void main(String[] args) {
        蓄水 s = new 蓄水();
        System.out.println(s.storeWater(new int[]{1, 3}, new int[]{6, 8}));
    }
    public int storeWater(int[] bucket, int[] vat) {
        int res = Integer.MAX_VALUE;
        int max = Arrays.stream(vat).max().getAsInt();
        if(max == 0) {
            return 0;
        }

        for(int i = 1; i <= max; i++) {
            int y = 0;
            for(int j = 0; j < bucket.length; j++) {
                y += Math.max(0, (vat[j] + i - 1) / i - bucket[j]);
            }
            res = Math.min(res, i + y);
        }
        return res;
    }
}
