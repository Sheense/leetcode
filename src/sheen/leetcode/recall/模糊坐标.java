package sheen.leetcode.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 模糊坐标
 * @Date 2022/11/7 12:23 上午
 * @Created by sheen
 * @Description TODO
 */
public class 模糊坐标 {
    public static void main(String[] args) {

    }

    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new ArrayList<>();
        s = s.substring(1, s.length() - 1);
        for(int i = 0; i < s.length() - 1; i++) {
            String a = s.substring(0, i + 1);
            String b = s.substring(i + 1);
            List<String> r1 = getALlNum(a);
            List<String> r2 = getALlNum(b);
            for(String key1 : r1) {
                for(String key2 : r2) {
                    res.add("(" + key1 + ", " + key2 + ")");
                }
            }
        }
        return res;
    }

    public List<String> getALlNum(String a) {
        List<String> res = new ArrayList<>();
        if(a.length() == 1) {
            res.add(a);
            return res;
        }
        if(a.charAt(0) != '0' && a.charAt(a.length() - 1) != '0') {
            res.add(a);
            for(int i = 0; i < a.length() - 1; i++) {
                res.add(a.substring(0, i + 1) + "." + a.substring(i + 1));
            }
        }else if(a.charAt(0) != '0' && a.charAt(a.length() -1) == '0') {
            res.add(a);
        }else if(a.charAt(0) == '0' && a.charAt(a.length() - 1) != '0') {
            res.add("0." + a.substring(1));
        }

        return res;
    }
}
