package sheen.leetcode.string;

public class 回文排列 {
    public boolean canPermutePalindrome(String s) {
        int[] arr = new int[256];
        for(int i=0;i<s.length();i++) {
            arr[s.charAt(i)]++;
        }
        boolean flag = false;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]%2==1) {
                if(flag) return false;
                flag = true;
            }
        }
        return true;
    }
}
