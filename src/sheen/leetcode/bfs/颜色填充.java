package sheen.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 颜色填充 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int len = image[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sr * len + sc);
        int old = image[sr][sc];
        while (!queue.isEmpty()) {
            int value = queue.poll();
            int x = value / len;
            int y = value % len;
            image[x][y] = newColor;
            if (x - 1 >= 0 && image[x-1][y] != newColor && image[x-1][y] == old) {
                queue.offer((x-1)*len + y);
            }
            if(x + 1 < image.length && image[x+1][y] != newColor && image[x+1][y] == old) {
                queue.offer((x+1)*len + y);
            }
            if (y - 1 >= 0 && image[x][y-1] != newColor && image[x][y-1] == old) {
                queue.offer(x*len + y-1);
            }
            if(y + 1 < image.length && image[x][y+1] != newColor && image[x][y+1] == old) {
                queue.offer(x*len + y + 1);
            }
        }
        return image;
    }
}
