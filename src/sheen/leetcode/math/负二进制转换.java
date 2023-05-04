package sheen.leetcode.math;

/**
 * @Classname 负二进制转换
 * @Date 2023/4/6 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 负二进制转换 {
    public static void main(String[] args) {
        负二进制转换 s = new 负二进制转换();
        System.out.println(s.baseNeg2(3));
    }
    public String baseNeg2(int n) {
        if(n == 0 || n == 1) {
            return String.valueOf(n);
        }

        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int r = n & 1;
            sb.append(r);
            n -= r;
            n /= -2;
        }

        return sb.reverse().toString();
    }


}
