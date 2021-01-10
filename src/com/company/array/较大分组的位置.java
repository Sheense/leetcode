package com.company.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 较大分组的位置 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        while(end<s.length()) {
            while(end<s.length()&&s.charAt(start)==s.charAt(end)) {
                end++;
            }
            if(end-start>=3) {
                res.add(Arrays.asList(start, end-1));
            }
            start = end;
        }
        return res;
    }
}
