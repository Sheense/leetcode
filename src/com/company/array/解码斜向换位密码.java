package com.company.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 解码斜向换位密码
 * @Date 2021/11/14 11:52 上午
 * @Created by sheen
 * @Description TODO
 */
public class 解码斜向换位密码 {
    public static void main(String[] args) {
        解码斜向换位密码 s = new 解码斜向换位密码();
        System.out.println(s.decodeCiphertext("ch   ie   pr", 3));
    }
    public String decodeCiphertext(String encodedText, int rows) {
        if(encodedText.length() == 0) return "";
        if(rows == 1) return encodedText;
         int column = encodedText.length() / rows;
         int len = 0;
         for(int i = 0; i < encodedText.length(); i++) {
             if(encodedText.charAt(i) != ' ') {
                 len++;
             }
         }
         List<String> arr = new ArrayList<>();
         int start = 0;
         for(int i = 0; i < rows; i++) {
             arr.add(encodedText.substring(start, start + column));
             start = start + column;
         }
         String res = "";
         int target = 0;
         for(int i = 0; i < column; i++) {
             int q = i;
             boolean end = false;
             for(int row = 0; row < arr.size(); row++) {
                 if(q >= arr.get(row).length()) {
                     break;
                 }
                 res += arr.get(row).charAt(q);
                 if(arr.get(row).charAt(q) != ' ') {
                     target ++;
                     if(target == len) {
                         end = true;
                         break;
                     }
                 }
                 q++;
             }
             if(end) {
                 break;
             }
         }

         return res;
    }
}
