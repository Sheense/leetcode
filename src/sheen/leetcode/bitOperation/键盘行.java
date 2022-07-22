package sheen.leetcode.bitOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 键盘行
 * @Date 2021/10/31 12:15 上午
 * @Created by sheen
 * @Description TODO
 */
public class 键盘行 {
    String[] strings = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        for(int i = 0 ; i < words.length; i++) {
            int index = check(words[i].charAt(0));
            boolean flag = true;
            for(int j = 0; j < words[i].length(); j++) {
                if(index != check(words[i].charAt(j))) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                res.add(words[i]);
            }
        }

        String[] r = new String[res.size()];
        for(int i = 0; i < r.length; i++){
            r[i] = res.get(i);
        }
        return r;
    }

    public int check(char c) {
        if(c >= 'A' && c <= 'Z') {
            c = (char) ((c - 'A') + 'a');
        }
        for(int i = 0 ; i < strings.length; i++) {
            if(strings[i].contains(String.valueOf(c))) {
                return i;
            }
        }
        return -1;
    }
}
