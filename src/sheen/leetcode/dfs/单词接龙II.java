package sheen.leetcode.dfs;

import java.util.*;

public class 单词接龙II {

    public static void main(String[] args) {
        单词接龙II s = new 单词接龙II();
        for(List<String> l : s.findLadders("red","tax", new ArrayList<>(Arrays.asList("ted","tex","red","tax","tad","den","rex","pee")))){
            System.out.println(l);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        if(!words.contains(endWord)) {
            return res;
        }
        if(words.contains(beginWord)) {
            words.remove(beginWord);
        }
        set.add(beginWord);
        wordList.add(beginWord);
        Map<String, Set<String>> check = new HashMap<>();
        for(int i=0;i<wordList.size();i++) {
            Set hashSet = new HashSet();
            for(int j = 0;j<beginWord.length();j++) {
                for(char z= 'a';z<='z';z++) {
                    String s;
                    if(j==0) {
                        s =  z+wordList.get(i).substring(j+1);
                    }else {
                        s = wordList.get(i).substring(0,j) + z+wordList.get(i).substring(j+1);
                    }
                    hashSet.add(s);
                }
            }
            check.put(wordList.get(i), hashSet);
        }

        Map<String, List<List<String>>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        map.computeIfAbsent(beginWord, x->new ArrayList<>()).add(list);
        while(words.size()!=0&&set.size()!=0) {
            for (String str:set) {
                if(check.get(str).contains(endWord)) {
                    List<List<String>> l = map.get(str);
                    for(List<String> arr : l) {
                        arr.add(endWord);
                        res.add(arr);
                    }
                }
            }
            if(res.size()!=0) return res;
            Map<String, List<List<String>>> newMap = new HashMap<>();
            for(String string:words) {
                for(String str:set) {
                    if(check.get(str).contains(string)) {
                        List<List<String>> l = map.get(str);
                        for(List<String> arr: l) {
                            List<String> list1 = new ArrayList<>(arr);
                            list1.add(string);
                            newMap.computeIfAbsent(string, x-> new ArrayList<>()).add(list1);
                        }
                    }
                }
            }
            set = newMap.keySet();
            words.removeAll(set);
            map = newMap;
        }
        return res;
    }

}
