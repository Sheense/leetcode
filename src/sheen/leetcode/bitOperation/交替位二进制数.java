package sheen.leetcode.bitOperation;

/**
 * @Classname 交替位二进制数
 * @Date 2022/3/28 12:24 上午
 * @Created by sheen
 * @Description TODO
 */
public class 交替位二进制数 {
    public boolean hasAlternatingBits(int n) {
        int m = n % 2 == 1 ? 0 : 1;
        while (n > 0) {
            int v = n % 2;
            if(v == m) {
                return false;
            }else {
                m = v;
            }
            n>>=1;
        }
        return true;
    }
}
