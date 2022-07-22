package sheen.leetcode.recall;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public static void main(String[] args) {
        括号生成 S = new 括号生成();
        System.out.println(S.generateParenthesis(0));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        match(0, n, "",res);
        return res;
    }

    public void match(int nums, int n, String now ,List<String> res) {
        if(nums<n) {
            match(nums+1,n,now+'(',res);
        }
        if(nums!=0) {
            if(n==1) {
                res.add(now+")");
                return ;
            }
            match(nums-1, n-1, now+')',res);
        }
    }

}
