package sheen.leetcode.math;

import sheen.leetcode.util.ArrayUtils;

public class 平分正方形 {
    public static void main(String[] args) {
        平分正方形 s = new 平分正方形();
        ArrayUtils.print(s.cutSquares(new int[]{-1, -1, 2}, new int[]{0, -1, 2}));
    }
    public double[] cutSquares(int[] square1, int[] square2) {
        double point1x = square1[0] + (double)square1[2]/2;
        double point1y = square1[1] + (double)square1[2]/2;

        double point2x = square2[0] + (double)square2[2]/2;
        double point2y = square2[1] + (double)square2[2]/2;

        int xLeft1 = square1[0];
        int xRight1 = square1[0] + square1[2];
        int yDown1 = square1[1];
        int yUp1 = square1[1] + square1[2];

        int xLeft2 = square2[0];
        int xRight2 = square2[0] + square2[2];
        int yDown2 = square2[1];
        int yUp2 = square2[1] + square2[2];
        int maxy = Math.max(Math.max(yDown1, yUp1), Math.max(yDown2, yUp2));
        int miny = Math.min(Math.min(yDown1, yUp1), Math.min(yDown2, yUp2));
        int maxx = Math.max(Math.max(xLeft1, xRight1), Math.max(xLeft2, xRight2));
        int minx = Math.min(Math.min(xLeft1, xRight1), Math.min(xLeft2, xRight2));

        if(point2x - point1x == 0) {
            double x = point1x;
            return new double[]{x, miny, x, maxy};
        }

        if(point1y - point2y == 0) {
            double y = point1y;
            return new double[]{minx, y, maxx, y};
        }

        double a = (point1y - point2y)/(point1x - point2x);
        double b = -a * point2x + point2y;

        if(Math.abs(a) >= 1) {
            double max_x = (maxy - b)/a;
            double min_x = (miny - b)/a;
            if(max_x >= min_x) {
                return new double[]{min_x, miny, max_x, maxy};
            }else{
                return new double[]{max_x, maxy, min_x, miny};
            }
        }else {
            double max_y = a * maxx + b;
            double min_y = a * minx + b;
            if(maxx == miny) {
                if(max_y >= min_y) {
                    return new double[]{minx, min_y, maxx, max_y};
                }else {
                    return new double[]{maxx, max_y, minx, min_y};
                }
            }
            return new double[]{minx, min_y, maxx, max_y};
        }
    }
}
