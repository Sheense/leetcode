package sheen.leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 划分字母区间 {

    public static void main(String[] args) {
        划分字母区间 s = new 划分字母区间();
        System.out.println(s.partitionLabels("bceacbacdbbadea"));
    }
    public List<Integer> partitionLabels(String S) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0;i<S.length();i++) {
            if(!map.containsKey(S.charAt(i))) {
                map.computeIfAbsent(S.charAt(i), x-> new ArrayList()).add(i);
            } else {
                List<Integer> list = map.get(S.charAt(i));
                if(list.size()==1) {
                    list.add(i);
                }else {
                    list.set(1, i);
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>(map.values());
        sort(list, 0, list.size()-1);
        List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = -1;
        for(int i=0;i<list.size();i++) {
            if(list.get(i).size()==1) {
                if(end==-1) {
                    res.add(1);
                }else {
                    if(list.get(i).get(0)>end) {
                        res.add(end-start+1);
                        res.add(1);
                        end = -1;
                    }
                }
            }else {
                if(end==-1) {
                    start = list.get(i).get(0);
                    end = list.get(i).get(1);
                }else {
                    if(end>list.get(i).get(0)) {
                        end = Math.max(list.get(i).get(1), end);
                    }else {
                        res.add(end-start+1);
                        start = list.get(i).get(0);
                        end = list.get(i).get(1);
                    }
                }
            }
        }
        if(end!=-1) res.add(end-start+1);
        return res;
    }
    public void sort(List<List<Integer>> list, int start, int end) {
        if(start>=end) return;
        int left = start;
        int right = end;
        List<Integer> m = list.get(left);
        while(left<right) {
            while(left<right&&list.get(right).get(0)>=m.get(0)) right--;
            list.set(left, list.get(right));
            while(left<right&&list.get(left).get(0)<=m.get(0)) left++;
            list.set(right, list.get(left));
        }
        list.set(left, m);
        sort(list, start, left-1);
        sort(list, left+1, end);
    }
}
