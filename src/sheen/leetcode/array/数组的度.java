package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class 数组的度 {

    public static void main(String[] args) {
        数组的度 s= new 数组的度();
        System.out.println(s.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }
    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
                right.put(nums[i], i);
            }else {
                map.put(nums[i], 1);
                left.put(nums[i],i);
                right.put(nums[i],i);
            }
        }
        int maxlen = 0;
        for(int value:map.values()) {
            if(value>maxlen) maxlen = value;
        }
        int res = Integer.MAX_VALUE;
        for(int key:map.keySet()) {
            if(map.get(key)==maxlen) {
                res = (right.get(key)-left.get(key)+1) <res?(right.get(key)-left.get(key)+1):res;
            }
        }
        return res;
    }
}
