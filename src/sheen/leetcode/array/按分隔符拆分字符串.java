package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 按分隔符拆分字符串
 * @Date 2024/1/20 00:00
 * @Created by sheen
 * @Description TODO
 */
public class 按分隔符拆分字符串 {
    public static void main(String[] args) {
        按分隔符拆分字符串 s = new 按分隔符拆分字符串();
        System.out.println(s.splitWordsBySeparator(Arrays.asList("..one..two.three..","four.five","six"), '.'));
    }
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < words.size(); i++) {
            int j = 0;
            while (j < words.get(i).length() && words.get(i).charAt(j) == separator) {
                j++;
            }
            int pre = j - 1;
            for(; j < words.get(i).length(); j++) {
                if(words.get(i).charAt(j) == separator) {
                    if(pre + 1 != j) {
                        res.add(words.get(i).substring(pre + 1, j));
                    }
                    pre = j;
                }
            }
            if(pre != words.get(i).length() - 1) {
                res.add(words.get(i).substring(pre + 1));
            }
        }
        return res;
    }
}
