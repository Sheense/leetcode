package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

import java.util.HashMap;
import java.util.Map;
//前缀和
public class 字母与数字 {

    public static void main(String[] args) {
        字母与数字 s = new 字母与数字();
        ArrayUtils.print(s.findLongestSubarray(new String[]{
                            "C","u","49","29","o","68","k","r","E","26","24","W","F","w","13","53","C","H","V","s","13","S","l","z","U","a","50","25","f","E","7","25","o","50","e","R","36","93","77","47","M","36","84","46","82","w","L","46","54","58","73","85","18","D","m","c","46","j","U","i","P","49","49","i","N","P","h","40","o","54","47","24","7","H","100","92","6","10","66","74","47","35","O","41","Z","9","37","S","A","g","78","C","X","1","28","B","s","R","81","q"
        }));
    }
    public String[] findLongestSubarray(String[] array) {
        int[] arr = new int[array.length];
        for(int i=0;i<array.length;i++) {
            try{
                Integer.parseInt(array[i]);
                arr[i] = 1;
            }catch (Exception e) {
                arr[i] = -1;
            }
        }
        int start = -1;
        int end = -1;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] add = new int[arr.length+1];
        for(int i=0;i<add.length;i++) {
            if(i==0) add[i] = 0;
            else {
                add[i] = add[i-1] + arr[i-1];
            }
            if(map.containsKey(add[i])) {
                int len = i - map.get(add[i]);
                if(len>maxLen) {
                    maxLen = len;
                    start = map.get(add[i]);
                    end = i;

                }
            }else {
                map.put(add[i], i);
            }
        }
        String[] res = new String[maxLen];
        int i = 0;
        for(;start<end;start++) {
            res[i++] = array[start];
        }
        return res;
    }
}
