package sheen.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname 驼峰式匹配
 * @Date 2023/4/14 12:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 驼峰式匹配 {
    public static void main(String[] args) {
        驼峰式匹配 s = new 驼峰式匹配();
        System.out.println(s.camelMatch(new String[]{"uAxaqlzahfialcezsLfj","cAqlzyahaslccezssLfj","AqlezahjarflcezshLfj","AqlzofahaplcejuzsLfj","tAqlzahavslcezsLwzfj","AqlzahalcerrzsLpfonj","AqlzahalceaczdsosLfj","eAqlzbxahalcezelsLfj"},
                "AqlzahalcezsLfj"));
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<String> p = getP(pattern);
        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < queries.length; i++) {

            List<String> item = getP(queries[i]);
            int j = 0;
            if(item.size() != p.size()) {
                if(item.size() == p.size() + 1 && pattern.charAt(0) >= 'A' && pattern.charAt(0) <= 'Z'
                    && queries[i].charAt(0) >= 'a' && queries[i].charAt(0) <= 'z') {
                    j = 1;
                }else {
                    res.add(false);
                    continue;
                }
            }
            boolean flag = true;
            int q = 0;
            for(; j < item.size(); j++) {
                if(!judge(p.get(q++), item.get(j))) {
                    flag = false;
                    break;
                }
            }
            res.add(flag);
        }
        return res;
    }

    public boolean judge(String a, String b) {
        int j = 0;
        for(int i = 0; i < b.length(); i++) {
            if(j == a.length()) {
                break;
            }

            if(b.charAt(i) == a.charAt(j)) {
                j++;
            }
        }
        return j == a.length();
    }

    public List<String> getP(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int index = i + 1;
            while (index < s.length() && s.charAt(index) >= 'a' && s.charAt(index) <= 'z') {
                index++;
            }
            res.add(s.substring(i, index));
            i = index;
        }
        return res;
    }
}
