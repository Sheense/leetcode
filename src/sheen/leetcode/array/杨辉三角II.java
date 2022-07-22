package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 杨辉三角II {

    public static void main(String[] args) {
        杨辉三角II s = new 杨辉三角II();
        System.out.println(s.getRow(2));
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex==1) return Arrays.asList(1,1);
        res.add(1);
        res.add(1);
        res.add(1);
        for(int i=2;i<=rowIndex;i++) {
            int t = i+1;
            int start = res.size()-t+1;
            int end = res.size()-1;
            res.add(1);
            for(;start<end;start++) {
                res.add(res.get(start)+res.get(start+1));
            }
            res.add(1);
        }
        return res.subList(res.size()-rowIndex-1,res.size());
    }
}
