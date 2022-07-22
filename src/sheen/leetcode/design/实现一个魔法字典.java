package sheen.leetcode.design;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 实现一个魔法字典
 * @Date 2022/7/11 12:51 上午
 * @Created by sheen
 * @Description TODO
 */
public class 实现一个魔法字典 {
    public static void main(String[] args) {
        MagicDictionary s = new MagicDictionary();
        s.buildDict(new String[]{"hello","leetcode"});
        s.search("hello");
    }

    static class MagicDictionary {

        private Set<String> set = new HashSet<>();
        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            for(String word : dictionary) set.add(word);
        }

        public boolean search(String searchWord) {
            for(int i = 0; i < searchWord.length(); i++) {
                for(int j = 0; j < 26; j++) {
                    String item = "";
                    if(i == 0) {
                        item = (char)(j + 'a') + searchWord.substring(1);
                    }else if(i == searchWord.length() - 1) {
                        item = searchWord.substring(0, searchWord.length() - 1) + (char)(j + 'a');
                    }else {
                        item = searchWord.substring(0, i) + (char)(j + 'a') + searchWord.substring(i + 1);
                    }
                    if(set.contains(item) && !item.equals(searchWord)) return true;
                }
            }
            return false;
        }
    }
}
