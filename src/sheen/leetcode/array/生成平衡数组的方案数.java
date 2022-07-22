package sheen.leetcode.array;

public class 生成平衡数组的方案数 {
    public static void main(String[] args) {
        生成平衡数组的方案数 s = new 生成平衡数组的方案数();
        System.out.println(s.waysToMakeFair(new int[]{1,2,3}));
    }
    public int waysToMakeFair(int[] nums) {
        int[] odd = new int[nums.length];
        int[] even = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(i%2==0) {
                if(i==0) {
                    even[i] = nums[i];
                }else {
                    even[i] = even[i-1] + nums[i];
                    odd[i] = odd[i-1];
                }
            }else {
                odd[i] = odd[i-1] + nums[i];
                even[i] = even[i-1];
            }
        }
        int res = 0;
        for(int i=0;i<nums.length;i++) {
            int oddNum = 0;
            int evenNum = 0;
            if(i==0) {
                oddNum = even[nums.length-1] - nums[i];
                evenNum = odd[nums.length-1];
            }else {
                oddNum = odd[i-1] + even[nums.length-1]-even[i];
                evenNum = even[i-1] + odd[nums.length-1] - odd[i];
            }
            if(oddNum==evenNum) res++;
        }
        return res;
    }
}
