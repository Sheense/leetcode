package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class 可被5整除的二进制前缀 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int item = 0;
        for(int i=0;i<A.length;i++) {
            item = item<<1;
            item += A[i];
            item %= 5;
            res.add(item%5==0);
        }
        return res;
    }
}
