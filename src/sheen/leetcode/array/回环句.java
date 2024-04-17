package sheen.leetcode.array;

/**
 * @Classname 回环句
 * @Date 2023/6/30 12:04 上午
 * @Created by sheen
 * @Description TODO
 */
public class 回环句 {
    public boolean isCircularSentence(String sentence) {
        String[] strs = sentence.split(" ");
        for(int i = 0; i < strs.length - 1; i++) {
            if(strs[i].charAt(strs[i].length() - 1) != strs[i + 1].charAt(0)) {
                return false;
            }
        }
        return strs[0].charAt(0) == strs[strs.length - 1].charAt(strs[strs.length - 1].length() - 1);
    }
}
