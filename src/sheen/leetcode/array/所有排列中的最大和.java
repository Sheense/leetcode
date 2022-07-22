package sheen.leetcode.array;

import java.util.Arrays;
//最优方案，也是这个问题实现最简单的方案，就是使用扫描线。即对于每一个request[start, end]，我们知道从 start 开始的数字多了一次查询，从 end + 1 开始的数字少了一次查询。
//
//用一个 freq 数组，对于每一个 request[start, end]，都进行 freq[start] ++ 和 freq[end + 1] -- 操作。
//
public class 所有排列中的最大和 {
    public static void main(String[] args) {
        所有排列中的最大和 s = new  所有排列中的最大和();
        System.out.println(s.maxSumRangeQuery(new int[]{1,2,3,4,5},new int[][]{{1,3},{0,1}}));
    }
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int[] arr = new int[nums.length];
        for(int i=0;i<requests.length;i++) {
            arr[requests[i][0]] ++;
            if(requests[i][1]+1<arr.length) {
                arr[requests[i][1]+1]--;
            }
        }
        for(int i=1;i<arr.length;i++) {
            arr[i] += arr[i-1];
        }
        long res = 0;
        Arrays.sort(arr);
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=0;i--) {
            if (arr[i]==0)break;
            res += (long)nums[i]*arr[i];
            res %= (Math.pow(10,9)+7);
        }
        return (int)res;
    }
}
