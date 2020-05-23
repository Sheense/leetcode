package com.company.array;

import com.company.util.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class 对角线遍历II {

    public static void main(String[] args) {
        对角线遍历II s = new 对角线遍历II();
        ArrayUtils.print(s.findDiagonalOrder(Arrays.asList(
                            Arrays.asList(14,12,19,16,9),//5
                            Arrays.asList(13,14,15,8,11),//5
                            Arrays.asList(11,13,1)



        )));
    }
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int size = 0;
        int maxLength = 0;
        for(int i=0;i<nums.size();i++) {
            size += nums.get(i).size();
            if(maxLength<=nums.get(i).size() - (nums.size()-i)) {
                maxLength = nums.get(i).size() - (nums.size()-i);
            }
        }
        int[] res = new int[size];
        int index =0;
        int rowMin = 0;
        for(int i=0;i<nums.size();i++) {
            int row = i;
            int j = 0;
            int r = rowMin;
            while(row>=r) {
                if(j<nums.get(row).size()){
                    res[index++] = nums.get(row).get(j);
                    rowMin = row;
                }
                row--;
                j++;
            }
            if(i==nums.size()-1) {
                int column = 1;
                row = i;
                j = column;
                rowMin = 0;
                while(column<=maxLength) {
                     r = rowMin;
                    while(row>=r){
                        if(j<nums.get(row).size()) {
                            res[index++] = nums.get(row).get(j);
                            rowMin = row;
                            if(index==res.length) return res;
                        }
                        j++;
                        row--;
                    }
                    row = i;
                    column++;
                    j = column;
                }
            }
        }
        return res;
    }
}
