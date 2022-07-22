package sheen.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 验证外星语词典
 * @Date 2022/5/17 12:18 上午
 * @Created by sheen
 * @Description TODO
 */
public class 验证外星语词典 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        String[] arr = new String[words.length];
        for(int i = 0; i < words.length; i++) {
            String str = "";
            for(int j = 0; j < words[i].length(); i++) {
                str += (char)(map.get(words[i].charAt(j)) + 'a');
            }
            arr[i] = str;
        }

        for(int i = 0; i <arr.length - 1; i++) {
            if(arr[i].compareTo(arr[i+1]) > 0) {
                return false;
            }
        }

        return true;

    }
}
