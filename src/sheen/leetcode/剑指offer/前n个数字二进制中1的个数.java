package sheen.leetcode.剑指offer;

/**
 * @Classname 前n个数字二进制中1的个数
 * @Date 2021/9/2 1:20 上午
 * @Created by sheen
 * @Description TODO
 */
public class 前n个数字二进制中1的个数 {
    public int[] countBits(int n) {
        int res[] = new int[n+1];
        for(int i = 0; i <= n; i++) {
            int count = 0;
            for(int j = 0; j <= 30; j ++) {
                if(((1<<j) & i) != 0) {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
