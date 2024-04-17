package sheen.leetcode.number;

/**
 * @Classname 统计能整除数字的位数
 * @Date 2023/10/26 00:11
 * @Created by sheen
 * @Description TODO
 */
public class 统计能整除数字的位数 {
    public int countDigits(int num) {
        int res = 0;
        int a = num;
        while (a != 0) {
            int yu =a % 10;
            if(num % yu == 0) {
                res ++;
            }
            a /= 10;
        }
        return res;
    }
}
