package sheen.leetcode.bitOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 猜字谜 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int[] puttleInt = new int[puzzles.length];
        for(int i=0;i<puttleInt.length;i++) {
            puttleInt[i] = getValue(puzzles[i]);
            map.computeIfAbsent(puzzles[i].charAt(0), x -> new ArrayList<>()).add(i);
        }
        int [] res = new int[puzzles.length];
        for(int i=0;i<words.length;i++) {
            int value = getValue(words[i]);
            for(int z = 0;z<26;z++) {
                if(((1<<z)^value) == value - (1<<z)) {
                    List<Integer> list = map.get((char)(z + 'a'));
                    if(list != null) {
                        for(int index:list) {
                            if((puttleInt[index]^value) == puttleInt[index] - value) {
                                res[index] ++;
                            }
                        }
                    }
                }
            }

        }
        List<Integer> r = new ArrayList<>();
        for(int i=0;i<res.length;i++) {
            r.add(res[i]);
        }
        return r;
    }

    public int getValue(String string) {
        boolean arr[] = new boolean[26];
        int value = 0;
        for(int j=0;j<string.length();j++) {
            int index = string.charAt(j) - 'a';
            if(arr[index]==false) {
                value += (1<<index);
                arr[index] = true;
            }
        }
        return value;
    }
}
