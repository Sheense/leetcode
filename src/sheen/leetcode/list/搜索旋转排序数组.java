package sheen.leetcode.list;

public class 搜索旋转排序数组 {

    public static void main(String[] args) {
        搜索旋转排序数组 s = new 搜索旋转排序数组();
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0) return -1;
        return find(nums, 0, nums.length-1,target);
    }
    public int find(int[] nums, int start, int end, int target) {
        if(start>end) return -1;
        if(start==end) {
            if(target==nums[start]) return start;
            else return -1;
        }
        if(nums[start]==target) return start;
        if(nums[end]==target) return end;
        int mid = (start+end)/2;
        if(nums[mid]==target) return mid;
        if(nums[start]>nums[mid]) {
            if(nums[start]<target||nums[mid]>target) {
               return find(nums, start, mid-1, target);
            } else {
                return find(nums,mid+1,end,target);
            }
        } else {
            if(nums[mid]>target&&nums[start]<target) {
                return find(nums, start, mid-1, target);
            } else {
                return find(nums,mid+1,end,target);
            }
        }
    }
}
