package sheen.leetcode.stack;

/**
 * @Classname 使括号有效的最少添加
 * @Date 2022/10/4 9:35 上午
 * @Created by sheen
 * @Description TODO
 */
public class 使括号有效的最少添加 {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int res = 0;
        for(int i =0 ; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                count ++;
            }else {
                if(count == 0) {
                    res++;
                }else {
                    count--;
                }
            }
        }
        res += count;
        return res;
    }
}
