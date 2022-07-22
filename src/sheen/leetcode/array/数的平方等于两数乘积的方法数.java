package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class 数的平方等于两数乘积的方法数 {

    public static void main(String[] args) {
        数的平方等于两数乘积的方法数 s = new 数的平方等于两数乘积的方法数();
        System.out.println(s.numTriplets(new int[]{1,1}, new int[]{1,1,1}));
    }
        public int numTriplets(int[] nums1, int[] nums2) {
            Map<Long, Integer> map1 = new HashMap<>();
            Map<Long, Integer> map2 = new HashMap<>();
            int i=0;
            int j=0;
            while(i<nums1.length||j< nums2.length) {
                if(i<nums1.length) {
                    map1.put((long)Math.pow(nums1[i], 2), map1.getOrDefault((long)Math.pow(nums1[i], 2), 0)+1);
                    i++;
                }
                if(j<nums2.length) {
                    map2.put((long)Math.pow(nums2[j], 2), map2.getOrDefault((long)Math.pow(nums2[j], 2), 0)+1);
                    j++;
                }
            }
            Map<Long, Integer> map3 = new HashMap<>();
            for(int z=0;z<nums1.length-1;z++) {
                for(int q=z+1;q<nums1.length;q++) {
                    map3.put((long)nums1[z]*nums1[q], map3.getOrDefault((long)nums1[z]*nums1[q], 0)+1);
                }
            }
            Map<Long, Integer> map4 = new HashMap<>();
            for(int z=0;z<nums2.length-1;z++) {
                for(int q=z+1;q<nums2.length;q++) {
                    map4.put((long)nums2[z]*nums2[q], map4.getOrDefault((long)nums2[z]*nums2[q], 0)+1);
                }
            }
            int res = 0;
            for(long v:map1.keySet()) {
                if(map4.containsKey(v)) {
                    res +=(map1.get(v)*map4.get(v));
                }
            }
            for(long v:map2.keySet()){
                if(map3.containsKey(v)) {
                    res += (map3.get(v)*map2.get(v));
                }
            }
            return res;
        }
}
