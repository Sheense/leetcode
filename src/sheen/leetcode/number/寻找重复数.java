package sheen.leetcode.number;

public class 寻找重复数 {

    public static void main(String[] args) {
        寻找重复数 s = new 寻找重复数();
        System.out.println(s.findDuplicate(new int[]{3,1,3,4,2}));
    }

    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=i+1) {
                int index = nums[i];
                while(index-1!=i&&nums[index-1]!=index&&nums[index-1]!=i+1) {
                    int item = nums[index-1];
                    nums[index-1] = index;
                    index = item;
                }
                if(nums[index-1]==index) {
                    return index;
                }
                if(nums[index-1]==i+1) {
                    nums[i] = nums[index-1];
                    nums[index-1] = index;
                }
            }
        }
        return 0;
    }
}
