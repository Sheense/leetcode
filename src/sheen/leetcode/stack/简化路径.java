package sheen.leetcode.stack;

import java.util.Stack;

public class 简化路径 {

    public static void main(String[] args) {
        简化路径 s = new 简化路径();
        System.out.println(s.simplifyPath("/a//b////c/d//././/.."));
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        stack.push(path.substring(0,1));
        int i= 1;
        while(i<path.length()) {
            String item = "";
            int j = i;
            while(j+1<=path.length()&&!path.substring(j,j+1).equals("/")) {
                j++;
            }
            item += path.substring(i,j);
            if(item.equals("..")) {
                if(stack.size()>1) stack.pop();
            }else if(!item.equals(".")&&!item.equals("/")&&!item.equals("")){
                stack.push(item);
            }
            i = j+1;
        }
        if(stack.size()==1) return "/";
        String res = "";
        while(!stack.isEmpty()) {
            if(stack.size()==1) {
                stack.pop();
            }else {
                res = "/"+stack.pop() + res;
            }
        }
        return res;
    }
}
