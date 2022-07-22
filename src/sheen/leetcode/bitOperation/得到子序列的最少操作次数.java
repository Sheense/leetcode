package sheen.leetcode.bitOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 得到子序列的最少操作次数
 * @Date 2021/7/26 1:38 上午
 * @Created by sheen
 * @Description TODO
 */
public class 得到子序列的最少操作次数 {
    public static void main(String[] args) {
        得到子序列的最少操作次数 s = new 得到子序列的最少操作次数();
        System.out.println(s.minOperations(new int[]{6,4,8,1,3,2}, new int[]{4,7,6,2,3,8,6,1}));
    }
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<target.length; i++) {
            map.put(target[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                list.add(map.get(arr[i]));
            }
        }

        List<Integer> item = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if(i == 0) {
                item.add(list.get(i));
            }else {
                int left = 0;
                int right = item.size() - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if(item.get(mid) >= list.get(i)) {
                        right = mid - 1;
                    }else {
                        left = mid + 1;
                    }
                }
                if(left == item.size()) {
                    item.add(list.get(i));
                }else {
                    item.set(left, list.get(i));
                }
            }
        }
        return target.length - item.size();
    }
}
