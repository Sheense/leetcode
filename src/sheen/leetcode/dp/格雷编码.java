package sheen.leetcode.dp;

import sheen.leetcode.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class 格雷编码 {

    public static void main(String[] args) {
        格雷编码 s = new 格雷编码();
        ArrayUtils.print(s.grayCode(3));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if(n==0) return res;
        int index = 0;
        while(index!=n) {
            int size = res.size();
            int add = 1<<index;
            for(int i=size-1;i>=0;i--) {
                res.add(res.get(i)+add);
            }
            index++;
        }
        return res;
    }
}
