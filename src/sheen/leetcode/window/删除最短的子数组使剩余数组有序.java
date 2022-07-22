package sheen.leetcode.window;

public class 删除最短的子数组使剩余数组有序 {
    public static void main(String[] args) {
        删除最短的子数组使剩余数组有序 s = new 删除最短的子数组使剩余数组有序();
        System.out.println(s.findLengthOfShortestSubarray(new int[]{1}));
    }
    public int findLengthOfShortestSubarray(int[] arr) {
        int start = 0;
        while(start+1<arr.length&&arr[start]<=arr[start+1]) {
            start++;
        }
        if(start==arr.length-1) return 0;
        int end = arr.length-1;
        while(end-1>=0&&arr[end]>=arr[end-1]) {
            end--;
        }
        if(arr[end]>=arr[start]) {
            return end - start -1;
        }
        int index = start;
        while(index>=0&&arr[index]>arr[end]){
            index--;
        }
        int min1 = end-index-1;

        index = end;
        while(index<arr.length&&arr[start]>arr[index]) {
            index++;
        }
        int min2 = index-start-1;
        return Math.min(min1, min2);
    }
}
