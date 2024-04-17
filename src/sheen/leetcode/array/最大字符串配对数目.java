package sheen.leetcode.array;

/**
 * @Classname 最大字符串配对数目
 * @Date 2024/1/17 00:02
 * @Created by sheen
 * @Description TODO
 */
public class 最大字符串配对数目 {
    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++) {
                if(new StringBuilder(words[j]).reverse().toString().equals(words[i])) {
                    count++;
                }
            }
        }
        return count;
    }
}
