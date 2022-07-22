package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 贴纸拼词
 * @Date 2022/5/14 1:00 下午
 * @Created by sheen
 * @Description TODO
 */
public class 贴纸拼词 {

    public static void main(String[] args) {

    }
    public int minStickers(String[] stickers, String target) {

        int[][] map = new int[stickers.length][26];
        for(int i = 0; i < stickers.length; i++) {
            for(int j = 0; j < stickers[i].length(); j++) {
                map[i][stickers[i].charAt(j) - 'a'] ++;
            }
        }
        int m = target.length();
        int[] res = new int[1 << m];
        Arrays.fill(res, - 1);
        res[0] = 0;
        int ans = dp(res, target, map, (1 << m) - 1);
        return ans <= m ? ans : -1;
    }

    public int dp(int[] res, String target, int[][] map, int mask) {
        if(res[mask] < 0) {
            int ans = target.length() + 1;
            for(int i = 0; i < map.length; i++) {
                int left = mask;
                int[] arr = Arrays.copyOf(map[i], map[i].length);
                for(int j = 0; j < target.length(); i++) {
                    int index = target.charAt(j) - 'a';
                    if(((left >> j) & 1) == 1 && arr[index] > 0) {
                        arr[index]--;
                        left -= (1 << j);
                    }
                }
                if(left < mask) {
                    ans = Math.min(ans, dp(res, target, map, left) + 1);
                }
            }
            res[mask] = ans;
        }
        return res[mask];
    }
}
