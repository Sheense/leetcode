package sheen.leetcode.math;

/**
 * @Classname 最大回文数乘积
 * @Date 2022/4/16 2:13 下午
 * @Created by sheen
 * @Description TODO
 */
public class 最大回文数乘积 {
    public static void main(String[] args) {
        最大回文数乘积 s = new 最大回文数乘积();
        System.out.println(s.largestPalindrome(1));
    }
    public int largestPalindrome(int n) {
        if(n == 1) {
            return 9;
        }
        int left = (int)Math.pow(10, n) - 1;
        int end = (int)Math.pow(10, n - 1);
        for(int i = left; i >= end; i--) {
            long num = process(i);
            for(int j = left; j >= end; j--) {
                long r = num / j;
                int count = count(r);
                if(num % j == 0 && count == n) {
                    return (int)(num % 1337);
                }

                if(count > n) {
                    break;
                }
            }
        }
        return 0;
    }

    public int count(long v) {
        int count = 0;
        while (v != 0) {
            count++;
            v/=10;
        }
        return count;
    }

    public long process(int left) {
        long res = left;
        while (left != 0) {
            res *= 10;
            res += left % 10;
            left /= 10;
        }
        return res;
    }
}
