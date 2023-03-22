package sheen.leetcode.string;

/**
 * @Classname 统计包含给定前缀的字符串
 * @Date 2023/1/8 12:21 上午
 * @Created by sheen
 * @Description TODO
 */
public class 统计包含给定前缀的字符串 {
    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for(int i = 0; i < words.length; i++) {
            if(words[i].startsWith(pref)) {
                res++;
            }
        }

        return res;
    }
}
