package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 最小绝对差
 * @Date 2022/7/4 12:45 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最小绝对差 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length - 1; i ++) {
            min = Math.min(arr[i + 1] - arr[i], min);
        }
        List<List<Integer>> res =  new ArrayList<>();
        for(int i = 0; i < arr.length - 1; i ++) {
            if(arr[i + 1] - arr[i] == min) {
                res.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }

        return res;
    }
}
