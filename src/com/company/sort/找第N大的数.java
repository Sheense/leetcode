package com.company.sort;

public class 找第N大的数{

    public static void main(String[] args) {
        找第N大的数 s = new 找第N大的数();
        int res = s.find(new int[]{1,9,5,7,2,4,6,10,3}, 1);
        System.out.println(res);
    }

    public int find(int[] array, int n) {
        if(array==null || array.length==0) return 0;
        return query(0, array.length-1, array, n);
    }

    public int query(int start ,int end , int[] array, int n) {
        int left = start;
        int right = end;
        while(left!=right) {
            while(left<right&&array[left]>=array[right]) right -- ;
            if(left==right) break;
            swap(left,right,array);
            while(left<right&&array[left]>=array[right]) left++;
            if(left==right) break;
            swap(left,right,array);
        }
        if(left==n-1) return array[left];
        if(n-1>left) {
            return query(left+1, end, array, n);
        } else {
            return query(start, left-1, array, n);
        }
    }

    public void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
