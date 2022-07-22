package sheen.leetcode.sort;

import java.util.Arrays;

/**
 * @Classname 摧毁小行星
 * @Date 2022/1/2 10:46 上午
 * @Created by sheen
 * @Description TODO
 */
public class 摧毁小行星 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long size = mass;
        for(int i = 0 ; i < asteroids.length; i++) {
            if(asteroids[i] <= size) {
                size += asteroids[i];
            }else {
                return false;
            }
        }
        return true;
    }
}
