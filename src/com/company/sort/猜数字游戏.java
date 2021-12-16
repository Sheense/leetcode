package com.company.sort;

import java.util.HashSet;

/**
 * @Classname 猜数字游戏
 * @Date 2021/11/8 12:33 上午
 * @Created by sheen
 * @Description TODO
 */
public class 猜数字游戏 {
    public String getHint(String secret, String guess) {
        int[] arr = new int[10];
        for(int i = 0 ; i < secret.length(); i++) {
            arr[secret.charAt(i) - '0'] ++;
        }
        int a = 0;
        int b = 0;
        boolean[] check = new boolean[secret.length()];
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                arr[secret.charAt(i) - '0'] --;
                check[i] = true;
                a++;
            }
        }

        for(int i = 0; i < secret.length(); i++) {
            if(!check[i]) {
                int index = guess.charAt(i) - '0';
                if(arr[index] > 0) {
                    arr[index]--;
                    b++;
                }
            }
        }

        return a + "A" + b + "B";
    }
}
