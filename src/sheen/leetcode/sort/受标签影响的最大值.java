package sheen.leetcode.sort;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 受标签影响的最大值
 * @Date 2023/5/23 12:24 上午
 * @Created by sheen
 * @Description TODO
 */
public class 受标签影响的最大值 {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        sort(values, labels, 0, values.length - 1);
        Map<Integer, Integer> map = new HashMap<>();
        int choose = 0;
        int res = 0;
        for(int i = 0; i < values.length && choose < numWanted; i++) {
            if(map.getOrDefault(labels[i], 0) < useLimit) {
                res += values[i];
                choose++;
                map.put(labels[i], map.getOrDefault(labels[i], 0) + 1);
            }
        }
        return res;
    }

    public void sort(int[] values, int[] labels, int left, int right) {
        if(left > right) {
            return;
        }
        int begin = left;
        int after = right;
        int target = values[left];
        int targetInx = labels[left];
        while (left < right) {
            while (left < right && values[right] <= target) right--;
            values[left] = values[right];
            labels[left] = labels[right];
            while (left < right && values[left] >= target) left++;
            values[right] = values[left];
            labels[right] = labels[left];
        }
        values[left] = target;
        labels[left] = targetInx;
        sort(values, labels, begin, left - 1);
        sort(values, labels, left + 1, after);
    }
}
