package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 情感丰富的文字
 * @Date 2022/11/25 12:13 上午
 * @Created by sheen
 * @Description TODO
 */
public class 情感丰富的文字 {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        List<int[]> mark = getAgg(s);
        for(int i = 0; i < words.length; i++) {
            List<int[]> item = getAgg(words[i]);
            if(item.size() != mark.size()) {
                continue;
            }

            boolean flag = true;
            for(int j = 0; j < item.size(); j++) {
                if(item.get(j)[0] != mark.get(j)[0] || item.get(j)[1] > mark.get(j)[1]) {
                    flag = false;
                    break;
                }

                if(item.get(j)[1] == mark.get(j)[1]) {
                    continue;
                }

                if(mark.get(j)[1] == 2) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                res++;
            }
        }

        return res;
    }

    public List<int[]> getAgg(String s) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int index = i;
            while (i < s.length() && s.charAt(i) == s.charAt(index)) {
                i++;
            }

            list.add(new int[]{s.charAt(index) - 'a', i - index});
        }

        return list;
    }
}
