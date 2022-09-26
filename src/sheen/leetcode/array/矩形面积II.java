package sheen.leetcode.array;

import java.util.*;

/**
 * @Classname 矩形面积II
 * @Date 2022/9/17 3:51 下午
 * @Created by sheen
 * @Description TODO
 */
public class 矩形面积II {
    public static void main(String[] args) {
        矩形面积II s = new 矩形面积II();
        System.out.println(s.rectangleArea(new int[][]{{0,0,2,2},{1,0,2,3},{1,0,3,1}}));
    }
    public int rectangleArea(int[][] rectangles) {
        Set<Integer> set = new HashSet<>();
        List<int[]> xList = new LinkedList<>();
        for(int i = 0 ; i < rectangles.length; i++) {
            set.add(rectangles[i][1]);
            set.add(rectangles[i][3]);
            xList.add(new int[]{rectangles[i][0], i, 1});
            xList.add(new int[]{rectangles[i][2], i, -1});
        }

        long res = 0;

        Collections.sort(xList, (x, y) -> {
            if(x[0] != y[0]) {
                return x[0] - y[0];
            }else if(x[1] != y[1]) {
                return x[1] - y[1];
            }else {
                return x[2] - y[2];
            }
        });

        List<Integer> yList = new LinkedList<>(set);
        Collections.sort(yList);
        int[] seg = new int[yList.size() - 1];
        for(int i = 0; i < xList.size(); i++) {
            int j = i;
            while (j + 1 < xList.size() && xList.get(j + 1)[0] == xList.get(i)[0]) {
                j++;
            }

            if(j + 1 >= xList.size()) {
                break;
            }

            for(int k = i; k <= j; k++) {
                int idx = xList.get(k)[1];
                int diff = xList.get(k)[2];
                int up = rectangles[idx][3];
                int down = rectangles[idx][1];
                for(int z = 0; z < seg.length; z++) {
                    if(yList.get(z) >= down && yList.get(z + 1) <= up) {
                        seg[z] += diff;
                    }
                }
            }

            long cover = xList.get(j + 1)[0] - xList.get(j)[0];
            for(int k = 0; k < seg.length; k++) {
                if(seg[k] > 0) {
                    int n = yList.get(k + 1) - yList.get(k);
                    res += (cover * (yList.get(k + 1) - yList.get(k)));
                }
            }
            i = j;
        }

        int mod = (int)Math.pow(10, 9) + 7;
        return (int)(res % mod);
    }
}
