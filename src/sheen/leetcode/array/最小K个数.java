package sheen.leetcode.array;

public class 最小K个数 {
    public int[] smallestK(int[] arr, int k) {
        sort(arr,0,arr.length-1);
        int[] res = new int[k];
        for(int i=0;i<k;i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public void sort(int[] arr, int start, int end) {
        if(start>=end) return;
        int left = start;
        int right = end;
        int key = arr[start];
        while(left<right) {
            while(left<right&&key<=arr[right]) right--;
            arr[left] = arr[right];
            while(left<right&&key>=arr[left]) left++;
            arr[right] = arr[left];
        }
        arr[left] = key;
        sort(arr, start,left-1);
        sort(arr,left+1,end);
    }
}
