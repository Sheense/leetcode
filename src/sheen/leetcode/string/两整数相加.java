package sheen.leetcode.string;

/**
 * @Classname 两整数相加
 * @Date 2023/5/5 3:43 下午
 * @Created by sheen
 * @Description TODO
 */
public class 两整数相加 {
    public static void main(String[] args) {
        两整数相加 s  =new 两整数相加();
        System.out.println(s.sum(888, -10));
    }
    public int sum(int num1, int num2) {
        do {
            int v1 = num1 ^ num2;
            int v2 = (num2 & num1) << 1;
            num1 = v1;
            num2 = v2;
        }while (num2 != 0);
        return  num1;
    }
}
