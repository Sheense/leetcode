package sheen.leetcode.math;

/**
 * @Classname 到达终点数字
 * @Date 2022/11/4 12:26 上午
 * @Created by sheen
 * @Description TODO
 */
public class 到达终点数字 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        int all = 0;
        while (all < target) {
            k++;
            all+=k;
        }
        int yu = all - target;
        if(yu % 2 == 0) {
            return k;
        }

        if(k % 2 == 1) {
            return k + 2;
        }

        return k + 1;
    }
}
