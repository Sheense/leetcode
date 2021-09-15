package com.company.string;

import java.util.Scanner;

/**
 * @Classname 小美的用户名
 * @Date 2021/8/29 7:41 下午
 * @Created by sheen
 * @Description TODO
 */
public class 小美的用户名 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.valueOf(scanner.nextLine());
        for(int i = 0; i < size; i++) {
            String str = scanner.nextLine();
            int num = 0;
            int mu = 0;
            boolean error = false;
            for(int j = 0; j < str.length(); j++) {
                if(j == 0 && !((str.charAt(j) >= 'a' && str.charAt(j) <= 'z')||(str.charAt(j) >= 'A' && str.charAt(j) <= 'Z'))) {
                    error =true;
                    break;
                }
                if((str.charAt(j) >= 'a' && str.charAt(j) <'z') || (str.charAt(j) >= 'A' && str.charAt(j) <= 'Z')) {
                    mu++;
                }else if(str.charAt(j) >= '0' && str.charAt(j) <= '9') {
                    num++;
                }else {
                    error = true;
                    break;
                }
            }
            if(error) {
                System.out.println("Wrong");
            }else {
                if(num >= 1 && mu >= 1) {
                    System.out.println("Accept");
                }else {
                    System.out.println("Wrong");
                }
            }
        }
    }
}
