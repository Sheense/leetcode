package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

public class 优美的排列II {

    public static void main(String[] args) {
        优美的排列II s = new 优美的排列II();
        ArrayUtils.print(s.constructArray(5,2));
    }
    public int[] constructArray(int n, int k) {
        int [] res = new int[n];
        int index = 0;
        int left = 1;
        int right = n;
        if(k==1) {
            for(int i=left;i<=right;i++) {
                res[index++] = i;
            }
            return res;
        }
        while(true) {
            res[index++] = left;
            left++;
            k--;
            if(k==1) {
                for(int i=right;i>=left;i--) {
                    res[index++] = i;
                }
                break;
            }
            res[index++]= right;
            right--;
            k--;
            if(k==1) {
                for(int i=left;i<=right;i++) {
                    res[index++] = i;
                }
                break;
            }
        }
        return res;
    }
}
