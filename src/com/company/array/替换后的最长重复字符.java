package com.company.array;

public class 替换后的最长重复字符 {
    public static void main(String[] args) {
        替换后的最长重复字符 s = new 替换后的最长重复字符();
        System.out.println(s.characterReplacement("AAAB", 0));
    }
    public int characterReplacement(String s, int k) {
        if(s.length()==0) return 0;
        int[] arr = new int[26];
        int max = 1;
        int left = 0;
        int right = 0;
        int maxIndex = -1;
        while(right<s.length()) {
            while(right<s.length()&&(maxIndex==-1||(right - left)-arr[maxIndex]<k||s.charAt(right)==('A' + maxIndex))) {
                arr[s.charAt(right) - 'A'] ++;
                right++;
                maxIndex = checkMax(arr);
            }
            max = (right - left) > max ? (right-left) :max;
            while(left<right&&(right - left)-arr[maxIndex]>=k) {
                arr[s.charAt(left)-'A']--;
                left++;
                maxIndex = checkMax(arr);
            }
            if(arr[maxIndex] == 0) maxIndex = -1;
        }
        return max;
    }

    public int checkMax(int[] arr) {
        int maxIndex = 0;
        int max = arr[0];
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
