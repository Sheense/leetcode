package sheen.leetcode.array;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname 通过删除字母匹配到字典里最长单词
 * @Date 2021/9/14 12:09 上午
 * @Created by sheen
 * @Description TODO
 */
public class 通过删除字母匹配到字典里最长单词 {
    public static void main(String[] args) {
        通过删除字母匹配到字典里最长单词 s = new 通过删除字母匹配到字典里最长单词();
        System.out.println(s.findLongestWord("abce", Arrays.asList("abe", "abc")));
    }
    public String findLongestWord(String s, List<String> dictionary) {
        int max = 0;
        String res = "";
        for(int i = 0 ; i < dictionary.size(); i++) {
            if(dictionary.get(i).length() >= max) {
                int j = 0;
                int z = 0;
                while (z < dictionary.get(i).length() && j < s.length()) {
                    if(dictionary.get(i).charAt(z) == s.charAt(j)) {
                        z ++;
                    }
                    j++;
                }
                if(z == dictionary.get(i).length() && dictionary.get(i).length() >= max) {
                    if(dictionary.get(i).length() == max) {
                        if(res.compareTo(dictionary.get(i)) > 0) {
                            res = dictionary.get(i);
                        }
                    }else {
                        max = dictionary.get(i).length();
                        res = dictionary.get(i);
                    }
                }
            }
        }
        return res;
    }
}
