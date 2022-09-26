package sheen.leetcode.bfs;

import javafx.util.Pair;

import java.util.*;

/**
 * @Classname 相似度为K的字符串
 * @Date 2022/9/21 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 相似度为K的字符串 {
    public static void main(String[] args) {
        相似度为K的字符串 s = new 相似度为K的字符串();
        System.out.println(s.kSimilarity("ab", "ba"));
    }
    public int kSimilarity(String s1, String s2) {
        Set<String> set = new HashSet<>();
        set.add(s1);
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(s1, 0));
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                Pair<String, Integer> item = queue.poll();
                String cur = item.getKey();
                int pos = item.getValue();
                if(cur.equals(s2)) {
                    return res;
                }
                while (pos < s2.length() && cur.charAt(pos) == s2.charAt(pos)) pos++;

                for(int i = pos + 1; i < cur.length(); i++) {
                    if(cur.charAt(i) == s2.charAt(i)) {
                        continue;
                    }
                    if(cur.charAt(i) == s2.charAt(pos)) {
                        char[] cs = cur.toCharArray();
                        char c = cs[i];
                        cs[i] = cs[pos];
                        cs[pos] = c;
                        String newStr = String.valueOf(cs);
                        if(!set.contains(newStr)) {
                            set.add(newStr);
                            queue.offer(new Pair<>(newStr, pos + 1));
                        }
                    }
                }
            }
            res++;
        }

        return res;
    }
}
