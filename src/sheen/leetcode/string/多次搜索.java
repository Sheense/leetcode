package sheen.leetcode.string;

import sheen.leetcode.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class 多次搜索 {
    public static void main(String[] args) {
        多次搜索 s = new 多次搜索();
        ArrayUtils.print2(s.multiSearch("mississippi", new String[]{"is","ppi","hi","sis","i","ssippi"}));
    }
    public int[][] multiSearch(String big, String[] smalls) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<smalls.length;i++) {
            List<Integer> item = new ArrayList<>();
            res.add(item);
            if(smalls[i].equals("")) continue;
            for(int j=0;j<=big.length() - smalls[i].length(); j++) {
                if(big.substring(j, j+smalls[i].length()).equals(smalls[i])) {
                    item.add(j);
                }
            }
        }
        int[][] ans = new int[smalls.length][1];
        for(int i=0;i<res.size();i++) {
            int[] item = new int[res.get(i).size()];
            for(int j=0;j<res.get(i).size();j++) {
                item[j] = res.get(i).get(j);
            }
            ans[i] = item;
        }
        return ans;
    }
}
