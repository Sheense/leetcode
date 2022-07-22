package sheen.leetcode.array;

public class 得到目标数组的最少函数调用次数 {
    public static void main(String[] args) {
        得到目标数组的最少函数调用次数 s = new 得到目标数组的最少函数调用次数();
        System.out.println(s.minOperations(new int[]{1,5}));
    }
    public int minOperations(int[] nums) {
        int noZero = 0;
        int other = 0;
        int maxTime = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>0) {
                noZero++;
                int time = 0;
                while(nums[i]!=1) {
                   if(nums[i]%2==1) {
                       nums[i]--;
                       other++;
                   }
                   nums[i] /= 2;
                   time++;
                }
                maxTime = Math.max(maxTime, time);
            }
        }
        int res = other + maxTime + noZero;
        return res;
    }
}
