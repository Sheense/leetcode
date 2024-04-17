package sheen.leetcode.array;

/**
 * @Classname 找出中枢整数
 * @Date 2023/6/26 12:20 上午
 * @Created by sheen
 * @Description TODO
 */
public class 找出中枢整数 {
    public int pivotInteger(int n) {
        int sum = (1 + n) * n / 2;
        int all = 0;
        for(int i = 1; i <= n; i++) {
            all += i;
            if(sum + i - all == all) {
                return i;
            }
        }
        return -1;
    }

}
