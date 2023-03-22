package sheen.leetcode.binarySearch;

import java.util.*;

/**
 * @Classname 匹配子序列的单词数
 * @Date 2022/11/17 12:21 上午
 * @Created by sheen
 * @Description TODO
 */
public class 匹配子序列的单词数 {
    public static void main(String[] args) {
        匹配子序列的单词数 s = new 匹配子序列的单词数();
        System.out.println(s.numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));
    }
    public int numMatchingSubseq(String s, String[] words) {
        List<Integer>[] pos = new List[26];
        for(int i = 0; i < pos.length; i++) {
            pos[i] = new ArrayList<>();
        }

        for(int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'].add(i);
        }

        int res = words.length;
        for(String word : words) {
            if(word.length() > s.length()) {
                res--;
                continue;
            }
            int p = -1;
            for(int i = 0; i < word.length(); i++) {
                List<Integer> list = pos[word.charAt(i)- 'a'];
                if(list.isEmpty() || list.get(list.size() - 1) <= p) {
                    res--;
                    break;
                }
                p = binSearch(list, p);
            }
        }

        return res;
    }

    public int binSearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(list.get(mid) > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }
}
