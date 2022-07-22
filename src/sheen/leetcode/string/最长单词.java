package sheen.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class 最长单词 {
    public static void main(String[] args) {
        最长单词 s = new 最长单词();
        System.out.println(s.longestWord(new String[]{""}));
    }
    public String longestWord(String[] words) {
        if(words.length == 1) return "";
        String res = "";
        sort(0, words.length-1, words);
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for(int i=1;i<words.length;i++) {
            if(recall(set, 0 ,words[i])) {
                if(words[i].length()>res.length()||((words[i].length() == res.length() && res.compareTo(words[i])>0))) {
                    res = words[i];
                }
            }
            set.add(words[i]);
        }
        return res;
    }

    public boolean recall(Set<String> set, int start, String target) {
        if(start == target.length()) return true;
        for(int i=start+1;i<=target.length();i++) {
            if(set.contains(target.substring(start, i))) {
                boolean flag = recall(set, i, target);
                if(flag) return true;
            }
        }
        return false;
    }

    public void sort(int start, int end, String[] words) {
        if(start>end) return;
        int left = start;
        int right = end;
        String m = words[start];
        while (left<right) {
            while (left<right&&m.length() <= words[right].length()) right--;
            words[left] = words[right];
            while (left<right&&m.length() >= words[left].length()) left++;
            words[right] = words[left];
        }
        words[left] = m;
        sort(start, left-1, words);
        sort(left + 1, end ,words);
    }
}
