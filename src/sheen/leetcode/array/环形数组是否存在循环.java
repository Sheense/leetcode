package sheen.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname 环形数组是否存在循环
 * @Date 2021/8/7 1:20 上午
 * @Created by sheen
 * @Description TODO
 */
public class 环形数组是否存在循环 {
    public boolean circularArrayLoop(int[] nums) {
        //已经有循环的节点
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            Map<Integer, Integer>  map = new HashMap<>();
            int index = 0;
            int next = i;
            boolean z = nums[i] > 0 ? true : false;
            while (!map.containsKey(next)&&!set.contains(next)) {
                map.put(next, index++);
                next = (next + nums[next]) % nums.length;
                if(next < 0) {
                    next += nums.length;
                }
                if( (nums[next] > 0) != z) {
                    break;
                }
            }
            if(set.contains(next) || (nums[next] > 0) != z) {
                continue;
            }
            int k = index - map.get(next);
            if(k > 1) {
                return true;
            }
            set.add(next);
        }
        return false;
    }
}
