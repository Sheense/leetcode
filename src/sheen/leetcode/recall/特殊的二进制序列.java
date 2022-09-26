package sheen.leetcode.recall;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname 特殊的二进制序列
 * @Date 2022/8/8 12:16 上午
 * @Created by sheen
 * @Description TODO
 */
public class 特殊的二进制序列 {
    public String makeLargestSpecial(String s) {
        if(s.length() < 2) {
            return s;
        }
        int count = 0;
        List<String> subString = new ArrayList<>();
        int left = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                count ++;
            }else {
                count --;
                if(count == 0) {
                    subString.add("1" + makeLargestSpecial(s.substring(left + 1, i - 1)) + "0");
                    left = i + 1;
                }
            }
        }

        Collections.sort(subString);
        String res = "";
        for(int i = subString.size() - 1; i >= 0; i--) {
            res += subString.get(i);
        }
        return res;
    }
}
