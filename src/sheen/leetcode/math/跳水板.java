package sheen.leetcode.math;

import sheen.leetcode.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class 跳水板 {
    public static void main(String[] args) {
        跳水板 s = new 跳水板();
        ArrayUtils.print(s.divingBoard(1,2,3));
    }
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0) return new int[]{};
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<=k;i++) {
            int num = (k-i)*shorter+i*longer;
            if(list.isEmpty()||list.get(list.size()-1)<num)
            list.add(num);
        }
        int[] res = new int[list.size()];
        for(int i=0;i<res.length;i++) {
            res[i] = list.get(i);
        }
        return res;
    }


}
