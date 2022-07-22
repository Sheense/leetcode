package sheen.leetcode.array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname 单词替换
 * @Date 2022/7/7 12:34 上午
 * @Created by sheen
 * @Description TODO
 */
public class 单词替换 {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>();
        for(String word : dictionary) {
            set.add(word);
        }

        String[] strings = sentence.split(" ");
        for(int i = 0; i < strings.length; i++) {
            for(int j = 0; j < strings[i].length(); j++) {
                String pre = strings[i].substring(0, j + 1);
                if(set.contains(pre)) {
                    strings[i] = pre;
                    break;
                }
            }
        }

       return String.join(" ", strings);
    }
}
