package com.company.greedyAlgorithm;

import java.util.PriorityQueue;

/**
 * @Classname 最长快乐字符串
 * @Date 2022/2/7 1:40 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最长快乐字符串 {
    public static void main(String[] args) {
        最长快乐字符串 s = new 最长快乐字符串();
        System.out.println(s.longestDiverseString(0, 8, 11));
    }
    public String longestDiverseString(int a, int b, int c) {
        int[] count = new int[]{a, b, c};
        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> count[o2-'a'] - count[o1 - 'a']);
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                queue.offer((char)('a' + i));
            }
        }
        String sb = "";
        while (!queue.isEmpty()) {
            char p = queue.poll();
            String s = String.valueOf(p) + p;
            if(sb.length() == 0 || sb.length() == 1 || !sb.substring(sb.length() - 2).equals(s)) {
                sb += p;
                count[p - 'a']--;
            }else {
                if(queue.isEmpty()) {
                    break;
                }
                char q = queue.poll();
                sb += q;
                count[q - 'a']--;
                if(count[q - 'a'] > 0) {
                    queue.offer(q);
                }
            }
            if(count[p - 'a'] > 0) {
                queue.offer(p);
            }
        }


        return sb;
    }
}
