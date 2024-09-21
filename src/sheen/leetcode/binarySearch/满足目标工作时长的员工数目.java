package sheen.leetcode.binarySearch;

import java.util.Arrays;

/**
 * @Classname 满足目标工作时长的员工数目
 * @Date 2024/4/30 00:15
 * @Created by sheen
 * @Description TODO
 */
public class 满足目标工作时长的员工数目 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        Arrays.sort(hours);
        int left = 0;
        int right = hours.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(hours[mid] >= target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return hours.length - left;
    }
}
