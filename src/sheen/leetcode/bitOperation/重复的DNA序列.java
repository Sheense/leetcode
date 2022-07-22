package sheen.leetcode.bitOperation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 重复的DNA序列 {
    public static void main(String[] args) {
        重复的DNA序列 s = new 重复的DNA序列();
        System.out.println(s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));

    }
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        boolean [] judge = new boolean[1<<20];
        int re = (1<<18)-1;
        int key = 0;
        for(int i=0;i<s.length();i++) {
            key <<=2;
            key += getValue(s.charAt(i));
            if(i>=9) {
                if(judge[key]) {
                    set.add(s.substring(i-9, i+1));
                }
                judge[key] = true;
            }
            key = key&re;
        }
        List<String> res = new ArrayList<>();
        for(String string : set) {
            res.add(string);
        }
        return res;
    }

    public int getValue(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: return 4;
        }
    }
}
