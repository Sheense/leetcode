package sheen.leetcode.binarySearch;

/**
 * @Classname _3的幂
 * @Date 2021/9/23 12:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class _3的幂 {
    public boolean isPowerOfThree(int n) {
        for(int i = 0; i < 31; i++) {
            long pow = (long)Math.pow(3, i);
            if(n < pow) {
                return false;
            }else if(n == pow) {
                return true;
            }
        }
        return false;
    }
}
