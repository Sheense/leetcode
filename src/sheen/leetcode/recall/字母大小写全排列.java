package sheen.leetcode.recall;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname 字母大小写全排列
 * @Date 2022/10/30 12:32 上午
 * @Created by sheen
 * @Description TODO
 */
public class 字母大小写全排列 {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        res.add("");
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<String> newRes = new ArrayList<>();
            for(String item : res) {
                newRes.add(item + c);
                if((c >= 'a' && c <= 'z')) {
                    newRes.add(item + (char)( (c - 'a') + 'A'));
                }else if(c >= 'A' && c <= 'Z') {
                    newRes.add(item + (char)( (c - 'A') + 'a'));
                }
            }
            res = newRes;
        }

        return res;
    }
}
