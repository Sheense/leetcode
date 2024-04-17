package sheen.leetcode.recall;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 活字印刷
 * @Date 2023/5/19 12:09 上午
 * @Created by sheen
 * @Description TODO
 */
public class 活字印刷 {

    public int numTilePossibilities(String tiles) {
        int res = 0;
        int arr[] = new int[26];
        for(int i = 0; i < tiles.length(); i++) {
            arr[tiles.charAt(i) - 'A'] ++;
        }
        for(int i = 1; i <= tiles.length(); i++) {
            Set<String> set = new HashSet<>();
            recall(i, arr, set, "");
            res += set.size();
        }
        return res;
    }

    public void recall(int targetLen, int[] arr, Set<String> set, String now) {
        if(targetLen == now.length()) {
            set.add(now);
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                arr[i]--;
                recall(targetLen, arr, set, now + (char)(i + 'A'));
                arr[i]++;
            }
        }
    }
}
