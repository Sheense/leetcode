package sheen.leetcode.stack;

public class 括号的最大嵌套深度 {
    public int maxDepth(String s) {
        int res = 0;
        int num = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') {
                num++;
                if(num>res) res = num;
            }
            if(s.charAt(i)==')') num--;
        }
        return res;
    }
}
