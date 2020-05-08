package com.company.array;

public class 将每个元素替换为右侧最大元素 {

    public int[] replaceElements(int[] arr) {
        int max = -1;
        for(int i=arr.length-1;i>=0;i--) {
            int item = arr[i];
            arr[i] = max;
            if(max<item) max = item;
        }
        return arr;
    }
}
