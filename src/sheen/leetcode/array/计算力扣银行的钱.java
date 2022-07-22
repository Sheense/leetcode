package sheen.leetcode.array;

/**
 * @Classname 计算力扣银行的钱
 * @Date 2022/1/15 1:13 下午
 * @Created by sheen
 * @Description TODO
 */
public class 计算力扣银行的钱 {
    public static void main(String[] args) {
        计算力扣银行的钱 s = new 计算力扣银行的钱();
        System.out.println(s.totalMoney(14));
    }
    public int totalMoney(int n) {
        int v = 28;
        int res = n / 7 * v;
        int a = 0;
        for(int i = 0; i < n / 7; i++) {
            res += a * 7;
            a ++;
        }
        res += n % 7 * a;
        for(int i = 0; i < n % 7; i++) {
            res += (i + 1);
        }
        return res;
    }
}
