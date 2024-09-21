package sheen.leetcode.math;

/**
 * @Classname 总行驶距离
 * @Date 2024/4/25 00:32
 * @Created by sheen
 * @Description TODO
 */
public class 总行驶距离 {
    public static void main(String[] args) {
        总行驶距离 s = new 总行驶距离();
        System.out.println(s.distanceTraveled(5, 10));
    }
    public int distanceTraveled(int mainTank, int additionalTank) {
        int res = 0;
        for(int i = 1; i <= mainTank; i++) {
            if(i % 5 == 0 && additionalTank > 0) {
                additionalTank--;
                mainTank++;
            }

            res += 10;
        }
        return res;
    }
}
