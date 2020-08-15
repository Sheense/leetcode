package com.company.array;

import java.util.LinkedList;
import java.util.Queue;

public class 图像渲染 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        Queue<Integer> x = new LinkedList<>();
        Queue<Integer> y = new LinkedList<>();
        int oldColor = image[sr][sc];
        x.offer(sr);
        y.offer(sc);
        while(!x.isEmpty()) {
            int size = x.size();
            while(size-->0) {
                int i = x.poll();
                int j = y.poll();
                image[i][j] = newColor;
                if(i-1>=0&&image[i-1][j]==oldColor&&image[i-1][j]!=newColor) {
                    x.offer(i-1);
                    y.offer(j);
                }
                if(j-1>=0&&image[i][j-1]==oldColor&&image[i][j-1]!=newColor) {
                    x.offer(i);
                    y.offer(j-1);
                }
                if(j+1<image[0].length&&image[i][j+1]==oldColor&&image[i][j+1]!=newColor) {
                    x.offer(i);
                    y.offer(j+1);
                }
                if(i+1<image.length&&image[i+1][j]==oldColor&&image[i+1][j]!=newColor) {
                    x.offer(i+1);
                    y.offer(j);
                }
            }
        }
        return image;
    }
}
