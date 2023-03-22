package sheen.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Classname 执行操作后字典序最小的字符串
 * @Date 2023/3/19 1:26 下午
 * @Created by sheen
 * @Description TODO
 */
public class 执行操作后字典序最小的字符串 {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> queue = new LinkedList<>();
        String ans = s;
        queue.offer(s);
        Set<String> set = new HashSet<>();
        set.add(s);
        while (!queue.isEmpty()) {
            String v = queue.poll();
            String p1 = planA(v, a);
            String p2 = planB(v, b);
            if(!set.contains(p1)) {
                if(p1.compareTo(ans) < 0) {
                    ans = p1;
                }
                queue.offer(p1);
                set.add(p1);
            }

            if(!set.contains(p2)) {
                if(p2.compareTo(ans) < 0) {
                    ans = p2;
                }
                queue.offer(p2);
                set.add(p2);
            }
        }

        return ans;

    }

    public String planA(String s, int a) {
        char[] cs = s.toCharArray();
        for(int i = 1; i < s.length() ; i+=2) {
            cs[i] = (char) (((cs[i] - '0') + a) % 10 + '0');
        }
        return String.valueOf(cs);
    }

    public String planB(String s, int b) {
        return s.substring(s.length() - b) + s.substring(0, s.length() - b);
    }

}
