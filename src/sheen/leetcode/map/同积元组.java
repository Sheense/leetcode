package sheen.leetcode.map;

import java.util.HashMap;
import java.util.Map;

public class 同积元组 {
    public static void main(String[] args) {
        同积元组 s = new 同积元组();
        System.out.println();
    }
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length-1;i++) {
            for(int j=i+1;j<nums.length;j++) {
                map.put(nums[i]*nums[j], map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        int res = 0;
        for(int key:map.keySet()) {
            res += (map.get(key)*(map.get(key)-1))/2 * 8;
        }
        return res;
    }
}
