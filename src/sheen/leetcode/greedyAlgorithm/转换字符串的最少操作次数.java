package sheen.leetcode.greedyAlgorithm;

/**
 * @Classname 转换字符串的最少操作次数
 * @Date 2022/12/27 12:10 上午
 * @Created by sheen
 * @Description TODO
 */
public class 转换字符串的最少操作次数 {
    public int minimumMoves(String s) {
        int i = 0;
        int res = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == 'O') {
                i++;
            }

            if(i < s.length()) {
                res++;
                i += 3;
            }
        }

        return res;
    }
}
