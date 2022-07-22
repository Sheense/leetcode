package sheen.leetcode.binarySearch;

public class 寻找旋转排序数组中的最小值 {
    public static void main(String[] args) {
        寻找旋转排序数组中的最小值 s = new 寻找旋转排序数组中的最小值();
        System.out.println(s.findMin(new int[]{1,2}));

    }

    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        Integer res = bin(0, nums.length-1, nums);
        return res==null?nums[0] : res;
    }

    public Integer bin (int start, int end, int[] nums) {
        if(start>end) return null;
        int mid = (start+end)/2;
        if(mid-1>=0 && nums[mid]<nums[mid-1]) {
            return nums[mid];
        }
        Integer res = bin(start,mid-1,nums);

        return res!=null ? res : bin(mid+1,end,nums);
    }
}
