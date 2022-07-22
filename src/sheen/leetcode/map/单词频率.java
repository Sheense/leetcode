package sheen.leetcode.map;

import java.util.HashMap;
import java.util.Map;

public class 单词频率 {
    class WordsFrequency {

        private Map<String, Integer> map = new HashMap<>();
        public WordsFrequency(String[] book) {
            for(int i=0;i<book.length;i++) {
                map.put(book[i], map.getOrDefault(book[i], 0) + 1);
            }
        }

        public int get(String word) {
            return map.getOrDefault(word, 0);
        }
    }
}
