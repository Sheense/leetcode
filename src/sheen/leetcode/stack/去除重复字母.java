package sheen.leetcode.stack;

import java.util.Stack;

public class 去除重复字母 {
    public String removeDuplicateLetters(String s) {
        int[] arr = new int[26];
        boolean[] vis = new boolean[26];
        for(int i=0;i<s.length();i++) {
            arr[s.charAt(i)-'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            if(!vis[s.charAt(i)-'a']) {
                while(!stack.isEmpty()&&stack.peek()>s.charAt(i)&&arr[stack.peek()-'a']>0) {
                    vis[stack.pop()-'a'] = false;
                }
                vis[s.charAt(i)-'a']=true;
                stack.push(s.charAt(i));
            }
            arr[s.charAt(i)-'a']--;
        }
        String res = "";
        while(!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }
}
