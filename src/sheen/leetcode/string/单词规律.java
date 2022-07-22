package sheen.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class 单词规律 {
    public static void main(String[] args) {
        单词规律 s = new 单词规律();
        System.out.println(s.wordPattern("abba", "dog cat cat dog"));
    }
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if(pattern.length()!=strings.length) return false;
        Map<Character, String> pToS = new HashMap<>();
        Map<String, Character> sToP = new HashMap<>();
        for(int i=0;i< pattern.length();i++) {
            if(pToS.containsKey(pattern.charAt(i))||sToP.containsKey(strings[i])) {
                if(pToS.containsKey(pattern.charAt(i))&&sToP.containsKey(strings[i])) {
                    if(!pToS.get(pattern.charAt(i)).equals(strings[i])||sToP.get(strings[i])!=pattern.charAt(i)) {
                        return false;
                    }
                }else {
                    return false;
                }
            }else {
                pToS.put(pattern.charAt(i), strings[i]);
                sToP.put(strings[i], pattern.charAt(i));
            }
        }
        return true;
    }
}
