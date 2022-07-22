package sheen.leetcode.math;

import java.util.Random;

/**
 * @Classname 在圆内随机生成点
 * @Date 2022/6/5 11:37 上午
 * @Created by sheen
 * @Description TODO
 */
public class 在圆内随机生成点 {
    class Solution {

        private double len;
        private double x;
        private double y;
        private Random random = new Random();
        public Solution(double radius, double x_center, double y_center) {
            this.len = radius;
            this.x = x_center;
            this.y = y_center;
        }

        public double[] randPoint() {
            while (true) {
                double a = random.nextDouble() * (2 * len) - len;
                double b = random.nextDouble() * (2 * len) - len;
                if(a * a + b * b <= len * len) {
                    return new double[]{a + this.x, b + this.y};
                }
            }

        }
    }
}
