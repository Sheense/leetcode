package sheen.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname 一个小组的最大实力值
 * @Date 2024/9/3 00:34
 * @Created by sheen
 * @Description TODO
 */
public class 一个小组的最大实力值 {
    public static void main(String[] args) {
        一个小组的最大实力值 s= new 一个小组的最大实力值();
        System.out.println(s.maxStrength(new int[]{3,-1,-5,2,5,-9}));
    }
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        List<Integer> z = new ArrayList<>();
        List<Integer> f = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        for(int v : nums) {
            if (v > 0) {
                z.add(v);
            }else if(v < 0) {
                f.add(v);
            }else {
                zero.add(v);
            }
        }

        long res = 1;
        for(int v : z) {
            res *= v;
        }

        long fRes = 1;
        Collections.sort(f);
        for(int i = 0; i < (f.size() % 2 == 0 ? f.size() : f.size() - 1); i++) {
            fRes *= f.get(i);
        }

        if(z.size() == 0) {
            if(f.size() >= 2) {
                return fRes;
            }else if (zero.size() > 0){
                return 0;
            }else {
                return f.get(0);
            }
        } else {
            return res * fRes;
        }

    }
}
