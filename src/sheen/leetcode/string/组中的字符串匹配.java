package sheen.leetcode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname 组中的字符串匹配
 * @Date 2022/8/6 7:14 下午
 * @Created by sheen
 * @Description TODO
 */
public class 组中的字符串匹配 {
    public static void main(String[] args) {
        组中的字符串匹配 s= new 组中的字符串匹配();
        s.stringMatching(new String[]{"leetcoder","leetcode","od","hamlet","am"});
    }
    public List<String> stringMatching(String[] words) {

        List<String> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if(i != j) {
                    if(words[j].contains(words[i])) {
                        res.add(words[i]);
                        break;
                    }
                }
            }
        }

        return res;
    }
}
