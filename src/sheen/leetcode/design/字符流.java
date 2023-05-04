package sheen.leetcode.design;

import sheen.leetcode.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Classname 字符流
 * @Date 2023/3/24 12:24 上午
 * @Created by sheen
 * @Description TODO
 */
public class 字符流 {
    public static void main(String[] args) {
        StreamChecker s = new StreamChecker(new String[]{"baa","aa","aaaa","abbbb","aba"});
        System.out.println(s.query('a'));
        System.out.println(s.query('a'));

        System.out.println(s.query('a'));

    }
    static class StreamChecker {

        private String[] words;
        private List<int[]> nexts = new ArrayList<>();
        private int[] indexs;
        public StreamChecker(String[] words) {
            this.words = words;

            for(int i = 0; i < words.length; i++) {
                nexts.add(getNext(words[i]));
            }
            this.indexs = new int[words.length];
        }

        public boolean query(char letter) {
            boolean res = false;
            for(int i = 0; i < indexs.length; i++) {
                if(words[i].charAt(indexs[i]) == letter) {
                    indexs[i]++;
                    if(indexs[i] == words[i].length()) {
                        indexs[i] = getNextIndex(letter, i, indexs[i]);
                        res = true;
                    }
                }else {
                    indexs[i] = getNextIndex(letter, i, indexs[i]);
                }
            }
            return res;
        }

        private int getNextIndex(char letter, int i, int index) {
            int[] next = nexts.get(i);
            while (next[index] != -1 && (index >= words[i].length() || words[i].charAt(next[index]) != letter)) {
                index = next[index];
            }
            return next[index] + 1;
        }

        private int[] getNext(String str) {
            int[] next = new int[str.length() + 1];
            next[0] = -1;
            for(int i = 1; i < next.length; i++) {
                int index = next[i - 1];
                while (index != -1 && str.charAt(index) != str.charAt(i - 1)) {
                    index = next[index];
                }
                next[i] = index + 1;
            }

            return next;
        }

    }
}
