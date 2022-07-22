package sheen.leetcode.sort;

public class 排序数组 {
    public static void main(String[] args) {

    }
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }
    public void sort(int[] nums, int start, int end) {
        if(start>=end) {
            return ;
        }
        int left = start;
        int right = end;
        int key = nums[start];
        while(left<right) {
            while(left<right&&key<=nums[right]) right--;
            nums[left] = nums[right];
            while(left<right&&key>=nums[left]) left++;
            nums[right] = nums[left];
        }
        nums[left] = key;
        sort(nums, start, left-1);
        sort(nums, left+1, end);
    }
}
