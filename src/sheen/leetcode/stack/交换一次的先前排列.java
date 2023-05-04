package sheen.leetcode.stack;

import sheen.leetcode.util.ArrayUtils;

import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Classname 交换一次的先前排列
 * @Date 2023/4/3 12:15 上午
 * @Created by sheen
 * @Description TODO
 */
public class 交换一次的先前排列 {
    public static void main(String[] args) {
        交换一次的先前排列 s = new 交换一次的先前排列();
        ArrayUtils.print(s.prevPermOpt1(new int[]{5,7,2,4}));
    }
    public int[] prevPermOpt1(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int i = arr.length - 1; i >= 0; i--) {
            if(map.floorKey(arr[i] - 1) != null) {
                int floorKey = map.floorKey(arr[i] - 1);
                Integer index = map.get(floorKey);
                if(index != null) {
                    int temp = arr[i];
                    arr[i] = arr[index];
                    arr[index] = temp;
                    return arr;
                }
            }
            map.put(arr[i], i);
        }
        return arr;
    }
}
