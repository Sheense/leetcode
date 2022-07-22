package sheen.leetcode.recall;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname 最长特殊序列Ⅰ
 * @Date 2022/3/5 1:35 下午
 * @Created by sheen
 * @Description TODO
 */
public class 最长特殊序列Ⅰ {
    public int findLUSlength(String a, String b) {
        return !a.equals(b) ? Math.max(a.length(), b.length()) : -1;
    }



}
