package sheen.leetcode.game;

import java.util.Arrays;

/**
 * @Classname 石子游戏VI
 * @Date 2024/2/2 00:29
 * @Created by sheen
 * @Description TODO
 */
public class 石子游戏VI {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int[][] arr = new int[aliceValues.length][3];
        for(int i = 0; i < arr.length; i++) {
            arr[i][0] = aliceValues[i] + bobValues[i];
            arr[i][1] = aliceValues[i];
            arr[i][2] = bobValues[i];
        }
        Arrays.sort(arr, (x, y) -> y[0] - x[0]);
        int a = 0;
        int b = 0;
        for(int i = 0; i < arr.length; i++) {
            if(i % 2 == 0) {
                a += arr[i][1];
            }else {
                b += arr[i][2];
            }
        }
        if(a > b) {
            return 1;
        }else if(a < b) {
            return -1;
        }else {
            return 0;
        }
    }
}
