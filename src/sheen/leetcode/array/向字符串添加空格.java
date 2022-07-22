package sheen.leetcode.array;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Classname 向字符串添加空格
 * @Date 2021/12/19 10:39 上午
 * @Created by sheen
 * @Description TODO
 */
public class 向字符串添加空格 {
    public String addSpaces(String s, int[] spaces) {
        int statt = 0;
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i < s.length(); i++) {
            if(statt < spaces.length && i == spaces[statt]) {
                sb.append(" ");
                statt++;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
