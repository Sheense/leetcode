package com.company.array;

import com.company.util.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        for(int i=0;i<nums.size();i++) {
            size += nums.get(i).size();
        }
        int[] res = new int[size];
        int index = 0;
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> column = new LinkedList<>();
        row.offer(0);
        column.offer(0);
        int rowNum = nums.size()-1;
        while(!row.isEmpty()) {
            int length = row.size();
            int top = row.peek();
            if(rowNum!=0) {
                rowNum--;
                row.offer(top+1);
                column.offer(0);
            }
            while(length!=0) {
                int i = row.poll();
                int j = column.poll();
                res[index++] = nums.get(i).get(j);
                if(j+1<nums.get(i).size()) {
                    row.offer(i);
                    column.offer(j+1);
                }
                length--;
            }
        }
        return res;
    }
}
