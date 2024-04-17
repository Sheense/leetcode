package sheen.leetcode.string;

/**
 * @Classname 子串能表示从1到N数字的二进制串
 * @Date 2023/5/11 1:19 上午
 * @Created by sheen
 * @Description TODO
 */
public class 子串能表示从1到N数字的二进制串 {
    public static void main(String[] args) {
        子串能表示从1到N数字的二进制串 s = new 子串能表示从1到N数字的二进制串();
        System.out.println(s.queryString("0110", 3));
    }
    public boolean queryString(String s, int n) {
        if(n == 1) {
            return s.contains("1");
        }
        int k = 0;
        while ((1 << k) < n) {
            k++;
        }

        for(int i = (1 << (k - 1)); i <= n; i++) {
            String item = Integer.toBinaryString(i);
            if(!s.contains(item)) {
                return false;
            }
        }
        return true;
    }
}
