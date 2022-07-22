package sheen.leetcode.array;

/**
 * @Classname 作为子字符串出现在单词中的字符串数目
 * @Date 2021/8/15 11:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 作为子字符串出现在单词中的字符串数目 {
    public int numOfStrings(String[] patterns, String word) {
        int res = 0;
        for(int i = 0; i < patterns.length; i++) {
            if(word.contains(patterns[i])) res++;
        }
        return res;
    }
}
