package sheen.leetcode.math;

/**
 * @Classname 圆和矩形是否有重叠
 * @Date 2023/6/25 12:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 圆和矩形是否有重叠 {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int dist = 0;
        if(xCenter > x2 || xCenter < x1) {
            dist += Math.min(Math.pow(x1 - xCenter, 2), Math.pow(x2 - xCenter, 2));
        }

        if(yCenter > y2 || yCenter < y1) {
            dist += Math.min(Math.pow(y1 - yCenter, 2), Math.pow(y2 - yCenter, 2));
        }
        return dist <= radius * radius;
    }
}
