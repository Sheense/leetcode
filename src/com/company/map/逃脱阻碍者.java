package com.company.map;

/**
 * @Classname 逃脱阻碍者
 * @Date 2021/8/22 12:27 上午
 * @Created by sheen
 * @Description TODO
 */
public class 逃脱阻碍者 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int my = len(0,0, target[0], target[1]);
        for(int i = 0; i < ghosts.length; i++) {
            if(my >= len(ghosts[i][0], ghosts[i][1], target[0], target[1])) {
                return false;
            }
        }
        return true;
    }

    public int len(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
