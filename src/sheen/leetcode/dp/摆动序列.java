package sheen.leetcode.dp;

public class 摆动序列 {
    public static void main(String[] args) {
        摆动序列 s = new 摆动序列();
        System.out.println(s.wiggleMaxLength(new int[]{1,7,4,9,2,5}));
    }
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==0) return 0;
        int upNum=1, downNum = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i-1]>nums[i]) {
                downNum = Math.max(downNum, upNum+1);
            }else if(nums[i-1]<nums[i]){
                upNum = Math.max(upNum, downNum+1);
            }
        }
        return Math.max(upNum, downNum);
    }
}
