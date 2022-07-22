package sheen.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class 将数组拆分成斐波那契序列 {
    public static void main(String[] args) {
        将数组拆分成斐波那契序列 s = new 将数组拆分成斐波那契序列();
        System.out.println(s.splitIntoFibonacci("123456579"));
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Long> list = new ArrayList<>();
        boolean flag = false;
        if(S.length()/3>=10) {
            flag = dfs(list, S, 0, 10);
        }else {
            flag = dfs(list, S, 0, S.length() / 3 + 1);
        }
        List<Integer> res = new ArrayList<>();
        if(flag) {
            for(int i=0;i<list.size();i++) {
                res.add(list.get(i).intValue());
            }
        }
        return res;
    }

    public boolean dfs(List<Long> res, String S, int start, int max) {
        if(start>=S.length()) {
            return true;
        }
        boolean flag = false;
        for(int i=start;i<max+start&&i<S.length();i++) {
            if(S.substring(start, start+1).equals("0")) {
                if(res.size()>=2) {
                    if(res.get(res.size()-1)+res.get(res.size()-2)==0) {
                        res.add(0L);
                        flag = dfs(res, S, i+1,max);
                        if(flag) break;
                        res.remove(res.size()-1);
                    }
                }else {
                    res.add(0L);
                    flag = dfs(res, S, i+1,max);
                    if(flag) break;
                    res.remove(res.size()-1);
                }
                break;
            }else {
                long num = Long.parseLong(S.substring(start, i+1));
                if(num>Integer.MAX_VALUE) {
                    break;
                }else {
                    if(res.size()>=2) {
                        if(res.get(res.size()-1)+res.get(res.size()-2)==num) {
                            res.add(num);
                            flag = dfs(res, S, i+1,max);
                            if(flag) break;
                            res.remove(res.size()-1);
                        }
                        if(res.get(res.size()-1)+res.get(res.size()-2)>Integer.MAX_VALUE){
                            break;
                        }
                    }else {
                        res.add(num);
                        flag = dfs(res, S, i+1,max);
                        if(flag) break;
                        res.remove(res.size()-1);
                    }
                }
            }
        }
        return flag;
    }
}
