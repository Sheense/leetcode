package com.company.binarySearch;

public class 可移除字符的最大数目 {
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean[] remove = new boolean[s.length()];
            for(int i = 0; i <= mid; i ++) {
                remove[removable[i]] = true;
            }
            int i = 0;
            int j = 0;
            while (i < s.length() && j < p.length()) {
                if(!remove[i] && s.charAt(i) == p.charAt(i)) {
                    j++;
                }
                i++;
            }

            if (j == p.length()) {
               left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }
}
