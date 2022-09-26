package sheen.leetcode.window;

import java.util.LinkedList;
import java.util.List;

/**
 * @Classname 最长优雅子数组
 * @Date 2022/9/4 5:07 下午
 * @Created by sheen
 * @Description TODO
 */
public class 最长优雅子数组 {
    public static void main(String[] args) {
        最长优雅子数组 s = new 最长优雅子数组();
        System.out.println(s.longestNiceSubarray(new int[]{3,1,5,11,13}));
    }
    public int longestNiceSubarray(int[] nums) {
        int maxLen = 1;
        int start = 0;
        int end = 0;
        int[] map = new int[32];
        while (end < nums.length) {
            boolean flag = true;
            while (end < nums.length) {
                List<Integer> list = getBin(nums[end]);
                add(map, list);
                end++;
                if(!check(map)) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                maxLen = Math.max(end - start, maxLen);
            }else {
                maxLen = Math.max(end - start - 1, maxLen);
            }
            while (start < end && !check(map)) {
                List<Integer> list = getBin(nums[start]);
                minus(map, list);
                start++;
            }
        }

        return maxLen;

    }

    public boolean check(int[] map) {
        for(int i = 0; i < map.length; i++) {
            if(map[i] > 1) {
                return false;
            }
        }
        return true;
    }

    public void minus(int[] map, List<Integer> arr) {
        for(int ind : arr) {
            map[ind]--;
        }
    }

    public void add(int[] map, List<Integer> arr) {
        for(int ind : arr) {
            map[ind]++;
        }
    }

    public List<Integer> getBin(int num) {
        List<Integer> res = new LinkedList<>();
        int count = 0;
        while (num > 0) {
            if((num & 1) == 1) {
                res.add(count);
            }
            count++;
            num >>= 1;
        }
        return res;
    }
}
