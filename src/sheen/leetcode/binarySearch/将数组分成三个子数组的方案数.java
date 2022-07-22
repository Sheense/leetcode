package sheen.leetcode.binarySearch;

public class 将数组分成三个子数组的方案数 {
    public static void main(String[] args) {
        将数组分成三个子数组的方案数 s = new 将数组分成三个子数组的方案数();
        System.out.println(s.waysToSplit(new int[]{0,0,0,0,0,1}));
    }
    public int waysToSplit(int[] nums) {
        for(int i=1;i<nums.length;i++) {
            nums[i] += nums[i-1];
        }
        int mod = (int)Math.pow(10,9)+7;
        long res = 0;
        for(int i=0;i<nums.length;i++) {
            int left = nums[i];
            int index = binarySearchLeft(i+1, nums.length-2, nums, 2 * left);;
            if(index==-1||index>=nums.length-1) {
                continue;
            }
            int target = (nums[nums.length-1] - left)/2+left;
            int index_1 = binarySearchRight(index, nums.length-2, nums, target);
            if(index_1==-1||index>=nums.length-1) {
                continue;
            }
            res += Math.max(0, index_1 - index + 1);
            res %= mod;
        }
        return (int)res;
    }
    //返回大于等于target的index
    public int binarySearchLeft(int start, int end, int [] nums, int target) {
        if(start>end) return -1;
        while (start<=end) {
            int mid = (start+end)/2;
            if(target>nums[mid]) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return start;
    }
    //返回小于等于target的index
    public int binarySearchRight(int start, int end, int [] nums, int target) {
        if(start>end) return -1;
        while (start<=end) {
            int mid = (start+end)/2;
            if(target>=nums[mid]) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return end;
    }
}
