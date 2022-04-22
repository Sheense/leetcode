package com.company.binarySearch;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Classname 寻找比目标字母大的最小字母
 * @Date 2022/4/3 12:53 上午
 * @Created by sheen
 * @Description TODO
 */
public class 寻找比目标字母大的最小字母 {
    public char nextGreatestLetter(char[] letters, char target) {
        Arrays.sort(letters);
        int left = 0;
        int right = letters.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(letters[mid] <= target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        if(left == letters.length) {
            return letters[0];
        }

        return letters[left];
    }
}
