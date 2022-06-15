package com.company.violence;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 掉落的方块
 * @Date 2022/5/26 1:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 掉落的方块 {
    public static void main(String[] args) {
        掉落的方块 s = new 掉落的方块();
        System.out.println(s.fallingSquares(new int[][]{{1,2},{2,3},{6,1}}));
    }
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < positions.length; i++) {
            int left = positions[i][0];
            int right = positions[i][1] + left - 1;
            int height = positions[i][1];
            int ans = height;
            for(int j = 0; j < i; j++) {
                int l = positions[j][0];
                int r =  positions[j][1] + l - 1;
                if(right >= l && r >= left) {
                    ans = Math.max(ans, res.get(j) + height);
                }
            }
            res.add(height);
        }

        for(int i = 1; i < res.size(); i++) {
            res.set(i, Math.max(res.get(i - 1), res.get(i)));
        }

        return res;
    }
}
