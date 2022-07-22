package sheen.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0) return res;
        res.add(Arrays.asList(1));
        if(numRows==1) return res;
        res.add(Arrays.asList(1,1));
        if(numRows==2) return res;
        for(int i=3;i<=numRows;i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j=1;j<i-1;j++) {
                List<Integer> last = res.get(res.size()-1);
                list.add(last.get(j-1)+last.get(j));
            }
            list.add(1);
            res.add(list);
        }
        return res;
    }
}
