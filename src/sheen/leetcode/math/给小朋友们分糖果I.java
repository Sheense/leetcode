package sheen.leetcode.math;

/**
 * @Classname 给小朋友们分糖果I
 * @Date 2024/6/1 01:33
 * @Created by sheen
 * @Description TODO
 */
public class 给小朋友们分糖果I {
    public static void main(String[] args) {
        给小朋友们分糖果I s = new 给小朋友们分糖果I();
        System.out.println(s.distributeCandies(5, 2));
    }
    public int distributeCandies(int n, int limit) {
        int res = 0;
        for(int i = 0; i <= limit && i <= n; i++) {
            for(int j = 0; j <= n - i && j <= limit; j++) {
                if (n - i - j >= 0 && n - i - j <= limit) {
                    res++;
                }
            }
        }
        return res;
    }
}
