package sheen.leetcode.array;

/**
 * @Classname 收集垃圾的最少总时间
 * @Date 2024/5/11 00:12
 * @Created by sheen
 * @Description TODO
 */
public class 收集垃圾的最少总时间 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[][] arr = new int[garbage.length][3];
        for(int i = 0; i < garbage.length; i++) {
            for(int j = 0; j < garbage[i].length(); j++) {
                if(garbage[i].charAt(j) == 'G') {
                    arr[i][0]++;
                }else if(garbage[i].charAt(j) == 'P') {
                    arr[i][1] ++;
                }else {
                    arr[i][2]++;
                }
            }
        }

        int res = 0;
        for(int i = 0; i < 3; i++) {
            int cost = 0;
            for(int j = 0; j < garbage.length; j++) {
                if(j > 0) {
                    cost += travel[j - 1];
                }
                if(arr[j][i] > 0) {
                    res += cost + arr[j][i];
                    cost = 0;
                }
            }
        }

        return res;
    }
}
