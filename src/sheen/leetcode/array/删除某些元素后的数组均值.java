package sheen.leetcode.array;

import java.util.Arrays;

/**
 * @Classname 删除某些元素后的数组均值
 * @Date 2022/9/14 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 删除某些元素后的数组均值 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int num = arr.length / 20;
        double all = 0;
        for(int i = num; i < arr.length - num; i++) {
            all += arr[i];
        }
        return all / (arr.length - 2 * num);
    }
}
