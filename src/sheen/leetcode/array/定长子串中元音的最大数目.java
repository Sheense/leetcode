package sheen.leetcode.array;

public class 定长子串中元音的最大数目 {
    public int maxVowels(String s, int k) {
        int[] arr = new int[s.length()];
        int max = 0;
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
                arr[i] = (i-1>=0?arr[i-1]:0)+1;
            }else {
                arr[i] = i-1>=0?arr[i-1]:0;
            }
            if(i==k-1) {
                max = arr[i];
            }
            if(i-k>=0) {
                if(arr[i]-arr[i-k]>max) {
                    max = arr[i]-arr[i-k];
                }
            }
        }
        return max;
    }
}
