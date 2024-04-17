package sheen.leetcode.binarySearch;

import java.util.Collections;
import java.util.List;

/**
 * @Classname 统计和小于目标的下标对数目
 * @Date 2023/11/24 00:13
 * @Created by sheen
 * @Description TODO
 */
public class 统计和小于目标的下标对数目 {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int res = 0;
        for(int i = 1; i < nums.size(); i++) {
            res += search(nums, 0, i - 1, target - nums.get(i)) + 1;
        }
        return res;
    }

    public int search(List<Integer> nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (right + left) / 2;
            if(nums.get(mid) >= target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return right;
    }
}
