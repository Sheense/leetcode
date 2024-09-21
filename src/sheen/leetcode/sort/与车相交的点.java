package sheen.leetcode.sort;

import java.util.Collections;
import java.util.List;

/**
 * @Classname 与车相交的点
 * @Date 2024/9/15 00:37
 * @Created by sheen
 * @Description TODO
 */
public class 与车相交的点 {
    public int numberOfPoints(List<List<Integer>> nums) {
        Collections.sort(nums, (x, y) -> x.get(0) - y.get(0));
        int res = 0;
        int pre = -1;
        for(List<Integer> list : nums) {
            if(list.get(0) > pre) {
                res += list.get(1) - list.get(0) + 1;
                pre = list.get(1);
            }else {
                if(pre < list.get(1)) {
                    res += list.get(1) - pre;
                    pre = list.get(1);
                }
            }
        }

        return res;
    }
}
