package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 找出峰值
 * @Date 2024/5/28 00:06
 * @Created by sheen
 * @Description TODO
 */
public class 找出峰值 {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i < mountain.length - 1; i ++) {
            if(mountain[i] > mountain[i - 1] && mountain[i + 1] < mountain[i]) {
                res.add(i);
            }
        }
        return res;
    }
}
