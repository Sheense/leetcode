package com.company.array;

/**
 * @Classname 下一个更大的数值平衡数
 * @Date 2021/10/24 4:11 下午
 * @Created by sheen
 * @Description TODO
 */
public class 下一个更大的数值平衡数 {
    public static void main(String[] args) {
        下一个更大的数值平衡数 s = new 下一个更大的数值平衡数();
        System.out.println(s.nextBeautifulNumber(749601));
    }
    public int nextBeautifulNumber(int n) {
        for(int i = n + 1; i <= Integer.MAX_VALUE; i++) {
            int arr[] = new int[10];
            int val = i;
            while (val != 0) {
                arr[val % 10]++;
                val /= 10;
            }
            boolean flag = true;
            for(int z = 0; z < arr.length; z++) {
                if(arr[z] == 0) {
                    continue;
                }
                if(z != arr[z] ) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                return i;
            }
        }
        return 0;
    }
}
