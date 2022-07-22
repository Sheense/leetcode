package sheen.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串 {

    public static void main(String[] args) {
        分割回文串 s = new  分割回文串();
        System.out.println(s.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        boolean[][] map = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
            for(int j=0;j+i<s.length();j++) {
                if(i==0) {
                    map[j][j] = true;
                    continue;
                }
                map[j][j+i] = i==1?(s.charAt(j+i)==s.charAt(j)): (s.charAt(j+i)==s.charAt(j)&&map[j+1][j+i-1]);
            }
        }
        List<List<String>> res = new ArrayList<>();
        find(map, res,new ArrayList<>(), 0,s);
        return res;
    }
    public void find(boolean[][] map, List<List<String>> res, List<String> now, int index, String s) {
        if(index>=s.length()) {
            res.add(now);
            return;
        }
        for(int i=index;i<s.length();i++) {
            if(map[index][i]) {
                String str = s.substring(index, i+1);
                List<String> next = new ArrayList<>(now);
                next.add(str);
                find(map, res, next, i+1,s);
            }
        }
    }
}
