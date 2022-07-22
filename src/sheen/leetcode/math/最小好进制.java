package sheen.leetcode.math;

public class 最小好进制 {
    public static void main(String[] args) {
        最小好进制 s = new 最小好进制();
        System.out.println(s.smallestGoodBase("4681"));
    }
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        int max_m = (int)Math.floor((Math.log(num) / Math.log(2)));
        for (int m = max_m; m > 1; m--) {
            int k = (int)Math.floor(Math.pow(num, 1.0 /m));
            long sum = 1;
            long numK = 1;
            for (int i = 0; i < m; i++) {
                numK *= k;
                sum += numK;
            }
            if (sum == num) {
                return String.valueOf(k);
            }
        }
        return String.valueOf(num - 1);
    }
}
