package sheen.leetcode.binarySearch;

import java.util.concurrent.SynchronousQueue;

/**
 * @Classname 第N个神奇数字
 * @Date 2022/11/22 12:29 上午
 * @Created by sheen
 * @Description TODO
 */
public class 第N个神奇数字 {
    public static void main(String[] args) {
        第N个神奇数字 s = new 第N个神奇数字();
        System.out.println(s.nthMagicalNumber(1, 2, 3));
    }
    public int nthMagicalNumber(int n, int a, int b) {
        long left = Math.min(a, b);
        long right = (long)Math.max(a, b) * n;
        int mod = 1000000007;
        int c = lcm(a, b);
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            long count = mid / a + mid / b - mid / c;
            if(count >= n) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }


        return (int)(left % mod);
    }

    public int lcm(int a, int b) {
        if(a > b) {
            return a * b / gcd(a, b);
        }

        return a * b / gcd(b, a);
    }

    public int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }


}
