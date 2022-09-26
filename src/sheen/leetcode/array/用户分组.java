package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 用户分组
 * @Date 2022/8/12 12:13 上午
 * @Created by sheen
 * @Description TODO
 */
public class 用户分组 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.computeIfAbsent(groupSizes[i], x -> new ArrayList<>());
            list.add(i);
            if(list.size() == groupSizes[i]) {
                res.add(list);
                map.remove(groupSizes[i]);
            }
        }
        return res;
    }
}
