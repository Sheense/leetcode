package sheen.leetcode.math;

/**
 * @Classname 复数乘法
 * @Date 2022/2/25 12:33 上午
 * @Created by sheen
 * @Description TODO
 */
public class 复数乘法 {
    public static void main(String[] args) {
        复数乘法 s = new 复数乘法();
        System.out.println(s.complexNumberMultiply("1+2i", "1+3i"));
    }
    public String complexNumberMultiply(String num1, String num2) {
        String[] str1 = num1.split("\\+");
        String[] str2 = num2.split("\\+");
        int a = Integer.valueOf(str1[0]);
        int b = Integer.valueOf(str1[1].substring(0, str1[1].length() - 1));
        int c = Integer.valueOf(str2[0]);
        int d = Integer.valueOf(str2[1].substring(0, str2[1].length() - 1));

        int e = a * c;
        int f = b * c + d * a;
        int h = -(b * d);
        e += h;
        String res = e + "+" + f + "i";
        return res;
    }
}
