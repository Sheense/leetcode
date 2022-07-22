package sheen.leetcode.greedyAlgorithm;

import java.util.*;

/**
 * @Classname 二倍数对数组
 * @Date 2022/4/1 12:12 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二倍数对数组 {
    public static void main(String[] args) {
        二倍数对数组 s = new 二倍数对数组();
        System.out.println(s.canReorderDoubled(new int[]{-5,-2}));
    }
    public boolean canReorderDoubled(int[] arr) {
        TreeMap<Double, Integer> zmap = new TreeMap();
        TreeMap<Double, Integer> fmap = new TreeMap<>();
        int fCount = 0;
        int zCount = 0;
        int zeroCount = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                zCount++;
                zmap.put((double)arr[i], zmap.getOrDefault((double)arr[i], 0) + 1);
            }else if(arr[i] < 0){
                fCount++;
                fmap.put((double)arr[i], fmap.getOrDefault((double)arr[i], 0) + 1);
            }else {
                zeroCount++;
            }
        }
        if(zCount % 2 == 1 || fCount % 2 == 1 || zeroCount % 2 == 1) {
            return false;
        }

        boolean res = check(zmap, true);
        if(!res) return false;



        return check(fmap, false);
    }

    public boolean check(TreeMap<Double, Integer> tree, boolean fu) {
        while (!tree.isEmpty()) {
            Double key = tree.firstKey();
            int count = tree.get(key);
            if(count == 1) {
                tree.remove(key);
            }else {
                tree.put(key, count -1);
            }
            double k = fu ?  key*2 : key/2;

            Integer nextCount = tree.get(k);
            if(nextCount == null || nextCount == 0) {
                return false;
            }

            if(nextCount == 1) {
                tree.remove(k);
            }else {
                tree.put(k, nextCount -1);
            }
        }
        return true;
    }
}
