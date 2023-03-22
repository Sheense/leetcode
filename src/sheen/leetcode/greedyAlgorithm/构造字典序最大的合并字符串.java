package sheen.leetcode.greedyAlgorithm;

/**
 * @Classname 构造字典序最大的合并字符串
 * @Date 2022/12/24 2:20 下午
 * @Created by sheen
 * @Description TODO
 */
public class 构造字典序最大的合并字符串 {
    public String largestMerge(String word1, String word2) {
        String res = "";
        int i = 0;
        int j = 0;
        while (i < word1.length() || j < word2.length()) {
            if(i == word1.length()) {
                res += word2.substring(j);
                j = word2.length();
                continue;
            }else if(j == word2.length()) {
                res += word1.substring(i);
                i = word1.length();
                continue;
            }

            if(word1.charAt(i) > word2.charAt(j)) {
                res += word1.charAt(i++);
            }else if(word1.charAt(i) < word2.charAt(j)) {
                res += word2.charAt(j++);
            }else {
                if(big(i + 1, j + 1, word1, word2)) {
                    res += word1.charAt(i++);
                }else {
                    res += word2.charAt(j++);
                }
            }
        }

        return res;
    }

    public boolean big(int i, int j, String word1, String word2) {

        if(i == word1.length() && j == word2.length()) {
            return true;
        }

        if(i == word1.length() && j != word2.length()) {
            return false;
        }
        if(i != word1.length() && j == word2.length()) {
            return true;
        }


        if(word1.charAt(i) != word2.charAt(j)) {
            return word1.charAt(i) > word2.charAt(j);
        }

        return big(i + 1, j + 1, word1, word2);
    }
}
