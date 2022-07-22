package sheen.leetcode.array;

/**
 * @Classname 句子中的最多单词数
 * @Date 2021/12/25 10:33 下午
 * @Created by sheen
 * @Description TODO
 */
public class 句子中的最多单词数 {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(int i = 0; i < sentences.length; i++) {
            int len = sentences[i].split(" ").length;
            max = Math.max(len, max);
        }
        return max;
    }
}
