package sheen.leetcode.math;

import java.util.Arrays;

/**
 * @Classname 移动石子直到连续
 * @Date 2023/4/30 11:24 上午
 * @Created by sheen
 * @Description TODO
 */
public class 移动石子直到连续 {
    public static void main(String[] args) {
        移动石子直到连续 s = new 移动石子直到连续();
        s.numMovesStones(1,3,5);
    }
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = new int[] {a, b, c};
        Arrays.sort(arr);
        int [] res = new int[2];

        if(arr[0] + 1 == arr[1] && arr[1] == arr[2] - 1) {
            return new int[]{0, 0};
        }
        if(arr[0] + 1 < arr[1] && arr[1] + 1 < arr[2]) {
            if(arr[0] + 1 == arr[1] - 1) {
                res[0] = 1;
            }else if(arr[1] + 1 == arr[2] - 1) {
                res[0] = 1;
            }else {
                res[0] = 2;
            }
        }else {
            res[0] = 1;
        }

        res[1] = arr[2] - arr[1] - 1 + arr[1] - arr[0] - 1;
        return res;
    }
}
