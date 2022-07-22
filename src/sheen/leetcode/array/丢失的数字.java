package sheen.leetcode.array;

public class 丢失的数字 {
    public int missingNumber(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==i) continue;
            if(nums[i]==nums.length) {
                nums[i] = -1;
                continue;
            }
            int j = nums[i];
            nums[i] = -1;
            while(j!=i&&j!=-1) {
                if(j==nums.length){
                    j=-1;
                }else {
                    int t = nums[j];
                    nums[j] = j;
                    j = t;
                }
            }
            nums[i] = j;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==-1) return i;
        }
        return nums.length;
    }
}
