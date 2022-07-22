package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 等差子数组 {
    public static void main(String[] args) {
        等差子数组 s = new 等差子数组();
        System.out.println(s.checkArithmeticSubarrays(new int[]{4,6,5,9,3,7}, new int[]{0,0,2}, new int[]{2,3,5}));
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for(int i=0;i<l.length;i++) {
            if(r[i] - l[i]==0||r[i]-l[i]==1) {
                res.add(true);
                continue;
            }
            int[] arr = new int[r[i]-l[i]+1];
            int index = 0;
            int start = l[i];
            while(start<=r[i]) {
                arr[index++] = nums[start++];
            }
            Arrays.sort(arr);
            boolean flag = true;
            int diff = arr[1] - arr[0];
            for(int j = 2;j<arr.length;j++) {
                if(diff!=arr[j]-arr[j-1]) {
                    flag = false;
                    break;
                }
            }
            res.add(flag);
        }
        return res;
    }
}
