package sheen.leetcode.array;

/**
 * @Classname 正整数和负整数的最大计数
 * @Date 2024/4/9 00:12
 * @Created by sheen
 * @Description TODO
 */
public class 正整数和负整数的最大计数 {
    public int maximumCount(int[] nums) {
        int a = 0;
        int b = 0;
        for(int v : nums) {
            if(v > 0) a++;
            if(v < 0) b++;
        }

        return Math.max(a, b);
    }
}
