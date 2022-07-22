package sheen.leetcode.sort;

public class 移除元素 {
    public static void main(String[] args) {
        移除元素 s = new 移除元素();
        System.out.println(s.removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }
    public int removeElement(int[] nums, int val) {
        int index =0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
