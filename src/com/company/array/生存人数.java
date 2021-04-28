package com.company.array;

public class 生存人数 {
    public int maxAliveYear(int[] birth, int[] death) {
        int[] arr = new int[101];
        for(int i=0;i<birth.length;i++) {
            for(int j = birth[i];j<=death[i];j++) {
                arr[j - 1900] ++;
            }
        }
        int maxYear = 0;
        int max = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] > max) {
                max = arr[i];
                maxYear = 1900 + i;
            }
        }
        return maxYear;
    }
}
