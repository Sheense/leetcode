package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 重新排列日志文件
 * @Date 2022/5/3 12:04 上午
 * @Created by sheen
 * @Description TODO
 */
public class 重新排列日志文件 {

    public static void main(String[] args) {
        重新排列日志文件 s = new 重新排列日志文件();
        ArrayUtils.print(s.reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"}));
    }
    public String[] reorderLogFiles(String[] logs) {
        List<String> numList = new ArrayList<>();
        List<String> charList = new ArrayList<>();
        for(int i = 0; i < logs.length; i++) {
            String[] str = logs[i].split(" ");
            if(str[1].charAt(0) >= 'a' && str[1].charAt(0) <= 'z') {
                charList.add(logs[i]);
            }else {
                numList.add(logs[i]);
            }
        }
        for(int i = 0; i < charList.size() - 1; i++) {
            for(int j = i; j < charList.size(); j++) {
                if(compare(charList.get(i), charList.get(j)) > 0) {
                    String str = charList.get(i);
                    charList.set(i, charList.get(j));
                    charList.set(j, str);
                }
            }
        }

        String[] res = new String[logs.length];
        int i = 0;
        for(int j = 0; j < charList.size(); j++) {
            res[i] = charList.get(j);
            i++;
        }

        for(int j = 0; j < numList.size(); j++) {
            res[i] = numList.get(j);
            i++;
        }

        return res;
    }

    public int compare(String str1, String str2) {
        String[] s1 = str1.split(" ");
        String[] s2 = str2.split(" ");

        int i = 1;
        int j = 1;
        while (i < s1.length && j < s2.length) {
            int sign = s1[i].compareTo(s2[j]);
            if(sign != 0) {
                return sign;
            }
            i++;
            j++;
        }

        if(i == s1.length && j != s2.length) {
            return -1;
        }

        if(i != s1.length && j == s2.length) {
            return 1;
        }

        return s1[0].compareTo(s2[0]);
    }
}
