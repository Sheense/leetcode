package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

import java.util.Arrays;

public class 根据数字二进制下1的数目排序 {
    public static void main(String[] args) {
        根据数字二进制下1的数目排序 s = new 根据数字二进制下1的数目排序();
        ArrayUtils.print(s.sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1}));
    }
    public int[] sortByBits(int[] arr) {
        int[] num = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<=14;j++) {
                int q = 1<<j;
                if((arr[i]&q)!=0) {
                    num[i]++;
                }
            }
        }
        sort(0, arr.length-1,arr,num);
        int index = 0;
        while(index<arr.length) {
            int end = index+1;
            while(end<arr.length&&num[index]==num[end]) end++;
            Arrays.sort(arr, index, end);
            index = end;
        }
        return arr;
    }

    public void sort(int start, int end, int arr[], int num[]) {
        if(start>=end) return;
        int left = start;
        int right = end;
        int midArr = arr[left];
        int midNum = num[left];
        while(left<right) {
            while(left<right&&midNum<=num[right]) right--;
            arr[left] = arr[right];
            num[left] = num[right];
            while(left<right&&midNum>=num[left]) left++;
            arr[right] = arr[left];
            num[right] = num[left];
        }
        arr[left] = midArr;
        num[left] = midNum;
        sort(start, left-1, arr, num);
        sort(left+1, end, arr, num);
    }
}
