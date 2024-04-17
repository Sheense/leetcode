package sheen.leetcode.array;

import java.util.List;

/**
 * @Classname 判别首字母缩略词
 * @Date 2023/12/20 00:26
 * @Created by sheen
 * @Description TODO
 */
public class 判别首字母缩略词 {
    public boolean isAcronym(List<String> words, String s) {
        String mod = "";
        for(String word : words) {
            mod += word.charAt(0);
        }

        return mod.equals(s);
    }
}
