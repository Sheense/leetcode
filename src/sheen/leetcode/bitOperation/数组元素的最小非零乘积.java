package sheen.leetcode.bitOperation;

/**
 * @Classname 数组元素的最小非零乘积
 * @Date 2021/8/15 11:41 上午
 * @Created by sheen
 * @Description TODO
 */
public class 数组元素的最小非零乘积 {
    public static void main(String[] args) {
        数组元素的最小非零乘积 s = new 数组元素的最小非零乘积();
        System.out.println(s.minNonZeroProduct(4));
    }
    int mod = (int)Math.pow(10, 9) + 7;
    public int minNonZeroProduct(int p) {
        long res = ((long)Math.pow(2, p) - 1) % mod;
        long count = ((long)Math.pow(2 , p) - 2) / 2;
        long item = ((long)Math.pow(2, p) - 2) % mod;
        return (int)((power(item, count) * res) % mod);
    }

    public long power(long value, long count) {
        if(count == 0) return 1;
        if(count == 1) return value;
        long res = count % 2 == 0 ? 1 : value;
        long n = power(value, count / 2);
        res = (res * n) % mod;
        res = (res * n) % mod;
        return res;
    }
}
