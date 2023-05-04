package sheen.leetcode.GeminiNeedle;

import java.util.*;

/**
 * @Classname 按字典序排在最后的子串
 * @Date 2023/4/24 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 按字典序排在最后的子串 {

    public static void main(String[] args) {
        按字典序排在最后的子串 s = new 按字典序排在最后的子串();
        System.out.println(s.lastSubstring("abab"));
    }
    public String lastSubstring(String s) {
        char maxChar = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> s.substring(y).compareTo(s.substring(x)));
        for(int i = 0; i < s.length(); i++) {
            if(maxChar < s.charAt(i)) {
                queue = new PriorityQueue<>((x, y) -> s.substring(y).compareTo(s.substring(x)));
                queue.add(i);
                maxChar = s.charAt(i);
            }else if(maxChar == s.charAt(i)) {
                queue.add(i);
            }
        }


        return s.substring(queue.peek());
    }
}
