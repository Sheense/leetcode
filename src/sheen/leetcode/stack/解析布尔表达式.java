package sheen.leetcode.stack;

import java.util.Stack;

/**
 * @Classname 解析布尔表达式
 * @Date 2022/11/5 11:49 上午
 * @Created by sheen
 * @Description TODO
 */
public class 解析布尔表达式 {
    public static void main(String[] args) {
        解析布尔表达式 s = new 解析布尔表达式();
        System.out.println(s.parseBoolExpr("!(&(!(&(f)),&(t),|(f,f,t)))"));
    }
    public boolean parseBoolExpr(String expression) {
        return recall(0, expression).res;
    }

    public class Result{
        Boolean res;
        int index;
        public Result(Boolean res, int index) {
            this.res = res;
            this.index = index;
        }
    }

    public Result recall(int index, String expression) {
        char c = expression.charAt(index);
        index+= 2;
        Boolean res = null;
        while (index < expression.length() && expression.charAt(index) != ')') {
            if(expression.charAt(index) == 't') {
                res = process(c, res, true);
            }else if(expression.charAt(index) == 'f') {
                res = process(c, res, false);
            }else if(expression.charAt(index) != ',') {
                Result ans = recall(index, expression);
                res = process(c, res, ans.res);
                index = ans.index;
            }
            index++;
        }
        Result ans = new Result(res, index);
        return ans;
    }

    public boolean process(char c, Boolean a, boolean b) {
        if(c == '!') {
            return !b;
        }

        if(c == '&') {
            return (a == null ? b : a) && b;
        }

        return (a == null ? b : a) || b;
    }


}
