package sheen.leetcode.tree;

/**
 * @Classname 字典序的第K小数字
 * @Date 2022/3/23 12:36 上午
 * @Created by sheen
 * @Description TODO
 */
public class 字典序的第K小数字 {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int step = getStep(cur, n);
            if(step <= k) {
                k -= step;
                cur++;
            }else {
                k--;
                cur *= 10;
            }
        }
        return cur;
    }

    public int getStep(int cur, int n) {
        int res = 0;
        long first = cur;
        long last = cur;
        while (first <= n) {
            res += Math.min(last, n) - first + 1;
            first *= 10;
            last = last * 10 + 9;
        }

        return res;
    }
}
