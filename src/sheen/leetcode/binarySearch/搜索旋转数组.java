package sheen.leetcode.binarySearch;

public class 搜索旋转数组 {
    public static void main(String[] args) {
        搜索旋转数组 s = new 搜索旋转数组();
        System.out.println(s.search(new int[]{-47, -42, -42, -42, -39, -36, -35, -33, -33, -32, -31, -28, -27, -26, -25, -24, -24, -19, -14, -7, -3, 1, 8, 8, 13, 14, 14, 15, 16, 17, 19, 21, 24, 25, 27, 28, 32, 33, 36, 39, 39, 43, 46, 46, 49, 55, 56, 58, 62, 63, 64, -62, -62, -60, -60, -58, -58, -57, -57, -53, -52, -51, -51, -47
        }, -42));
    }
    public int search(int [] arr, int target) {
        return search(arr, target, 0, arr.length-1);
    }

    public int search(int[] arr, int target, int start, int end) {
        if(start>end) {
            if(end>=0&&end<arr.length&&arr[end] == target) return end;
            if(start>=0&&start<arr.length&&arr[start] == target) return start;
            return -1;
        }
        int mid = (start + end)/2;
        if(arr[start] <= target || arr[mid]>=target) {
            int res = search(arr,target, start, mid-1);
            if(res != -1) return res;
        }

        if(arr[mid] <= target||arr[end]>=target) {
            int res = search(arr, target, mid+1, end);
            if(res != -1) return res;
        }
        return -1;
    }

}
