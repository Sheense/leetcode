package sheen.leetcode.number;

/**
 * @Classname 倍数求和
 * @Date 2023/10/17 01:13
 * @Created by sheen
 * @Description TODO
 */
public class 倍数求和 {
    public int sumOfMultiples(int n) {
        int a = 0;
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0) {
                a += i;
            }else if(i % 5 == 0) {
                a += i;
            }else if(i % 7 == 0) {
                a += i;
            }
        }
        return a;
    }
}
