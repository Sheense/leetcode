package sheen.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 山羊拉丁文
 * @Date 2022/4/21 12:25 上午
 * @Created by sheen
 * @Description TODO
 */
public class 山羊拉丁文 {
    public String toGoatLatin(String sentence) {
        String[] strs = sentence.split(" ");
        Set<Character> set = new HashSet<>();
        set.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        set.addAll(Arrays.asList('A', 'E', 'I', 'O', 'U'));
        String[] res = new String[strs.length];
        for(int i = 0; i < strs.length; i++) {
            if(set.contains(strs[i].charAt(0))) {
                res[i] = strs[i] + "ma" + getA(i);
            }else {
                res[i] = strs[i].length() == 1 ? strs[i] + "ma" + getA(i) : strs[i].substring(1) + strs[i].charAt(0) + "ma" + getA(i);
            }
        }
        String ans = "";
        for(int i = 0; i < res.length; i++) {
            ans += res[i];
            if(i != res.length - 1) {
                ans += " ";
            }
        }
        return ans;
    }

    public String getA(int i) {
        String res = "";
        for(int j = 0; j <= i; i++) {
            res += "a";
        }
        return res;
    }
}
