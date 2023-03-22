package sheen.leetcode.array;

/**
 * @Classname 生成交替二进制字符串的最少操作数
 * @Date 2022/11/29 12:13 上午
 * @Created by sheen
 * @Description TODO
 */
public class 生成交替二进制字符串的最少操作数 {
    public static void main(String[] args) {
        生成交替二进制字符串的最少操作数 s= new 生成交替二进制字符串的最少操作数();
        System.out.println(s.minOperations("0100"));
    }
    public int minOperations(String s) {
        char pre = '1';
        int a = 0;
        for(int i = 0; i < s.length(); i++) {
            if(pre == s.charAt(i)) {
                a++;
            }
            if(pre == '1') {
                pre = '0';
            }else {
                pre = '1';
            }
        }

        pre = '0';
        int b = 0;
        for(int i = 0; i < s.length(); i++) {
            if(pre == s.charAt(i)) {
                b++;
            }
            if(pre == '1') {
                pre = '0';
            }else {
                pre = '1';
            }
        }

        return Math.min(a, b);
    }
}
