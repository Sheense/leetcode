package sheen.leetcode.binarySearch;

public class 搜索旋转排序数组II {

    public static void main(String[] args) {
        搜索旋转排序数组II s = new 搜索旋转排序数组II();
        System.out.println(s.search(new int[]{4,5,6,7,0,1,2}, 1));
    }

    /*public boolean search(int[] nums, int target) {
        return search(0, nums.length-1, nums, target);
    }

    public boolean search(int start, int end, int[] nums, int target) {
        if(start==end) return nums[start] == target;
        if(start>end) return false;
        int mid = (start+end)/2;
        if(nums[start]==target||nums[end]==target||nums[mid]==target) return true;
        if(start+1==end) return false;
        int left = mid+1;
        int right = mid-1;
        if((left<nums.length&&nums[left]==target)||(right>=0&&nums[right]==target)) return true;
        while(right-1>=start&&nums[right-1]==nums[mid])right--;
        while(start+1<=right&&nums[start+1]==nums[start])start++;
        while(end-1>=left&&nums[end-1]==nums[end])end--;
        while(left+1<=end&&nums[left+1]==nums[left])left++;

        if((nums[start]<=nums[right]&&nums[right]>=target&&nums[start]<=target)||(nums[start]>nums[right]&&(nums[start]<=target||target<=nums[right]))) {
            return search(start, right, nums, target);
        } else {
            return search(left, end, nums, target);
        }
    }*/
    public boolean search(int[] nums, int target) {
        int end = 0;
        while (end+1<nums.length&&nums[end]<=nums[end+1]) {
            end++;
        }
        if(nums[0] == target || nums[end] == target) return true;
        if(nums[0]<=target&&nums[end]>=target) {
            return search(0, end, nums, target);
        }
        return search(end+1, nums.length - 1, nums, target);
    }

    public boolean search(int start, int end, int[] nums, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) return true;
            else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
