package com.company.bitOperation;

import com.company.util.ArrayUtils;

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
        int j = 0;
        while(res.size()<(Math.pow(2, n+1)-1)) {
            int index = 0;
            while(index<n&&res.size()<(Math.pow(2, n+1)-1)){
                j += Math.pow(2, index);
                res.add(j);
                index++;
            }
            if(res.size()<(Math.pow(2, n+1)-1)) break;
            index = 0;

        }
        return res;
    }
}
