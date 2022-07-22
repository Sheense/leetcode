package sheen.leetcode.binarySearch;

public class 将x减到0的最小操作数 {
    public static void main(String[] args) {
        将x减到0的最小操作数 s = new 将x减到0的最小操作数();
        System.out.println(s.minOperations(new int[]{1,1,4,2,3}, 5));
    }

    public int minOperations(int[] nums, int x) {
        int arr[] = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(i==0) arr[i] = nums[i];
            else arr[i] = arr[i-1] + nums[i];
        }
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int index = arr.length;
        do {
            int target = x - sum;
            if(target==0) res = Math.min(arr.length-index,res);
            else if(target<0) {
                break;
            }
            int start = 0;
            int end = index-1;
            int r = search(arr, target, start, end);
            if(r!=-1) res = Math.min(r+1+arr.length-index,res);
            sum+=nums[--index];
        }while (index>0);
        return res==Integer.MAX_VALUE?-1:res;
    }

    public int search(int [] arr, int target, int start, int end) {
        while(start<=end) {
            int mid = (start+end)/2;
            if(arr[mid]==target) {
                return mid;
            }else if(arr[mid]>target){
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return -1;
    }
}
