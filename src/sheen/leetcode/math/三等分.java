package sheen.leetcode.math;

import sheen.leetcode.util.ArrayUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @Classname 三等分
 * @Date 2022/10/6 12:09 上午
 * @Created by sheen
 * @Description TODO
 */
public class 三等分 {
    public static void main(String[] args) {
        三等分  s = new 三等分();
        ArrayUtils.print(s.threeEqualParts(new int[]{1, 1,  0, 0, 1}));
    }
    public int[] threeEqualParts(int[] arr) {
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                list.add(i);
            }
        }
        if(list.size() % 3 > 0) {
            return new int[]{-1, -1};
        }
        if(list.size() == 0) {
            return new int[]{0, 2};
        }
        int part = list.size() / 3;
        int first = list.get(0);
        int second = list.get(part);
        int third = list.get(part * 2);
        int len = arr.length - third;
        if(len + first > second) {
            return new int[]{-1, -1};
        }
        if(len + second > third) {
            return new int[]{-1, -1};
        }
        int indexT = third;
        int indexS = second;
        int indexF = first;
        while (indexT < arr.length) {
            if(arr[indexT] != arr[indexF] || arr[indexF] != arr[indexS]) {
                return new int[]{-1, -1};
            }
            indexT++;
            indexS++;
            indexF++;
        }

        return new int[]{indexF -1, indexS};
    }
}
