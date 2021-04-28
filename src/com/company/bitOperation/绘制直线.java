package com.company.bitOperation;

import com.company.util.ArrayUtils;

public class 绘制直线 {
    public static void main(String[] args) {
        绘制直线 s = new 绘制直线();
        System.out.println(s.getValueByBit(0,31));
        ArrayUtils.print(s.drawLine(6,96,20,90,1));
    }
    public int[] drawLine(int length, int w, int x1, int x2, int y) {
        int [] res = new int[length];
        int row = length / (w / 32);
        int column = w/32;
        for(int i=0;i<row;i++) {
            if(i==y) {
                int j = 0;
                while ((j+1)*32<=x1) {
                    j++;
                }
                int start = x1;
                int end = Math.min(x2, (j+1) * 32 - 1);
                do {
                    res[i*column + j] = getValueByBit(start%32, end%32);
                    start = (j+1) * 32;
                    j++;
                    end = Math.min((j+1) *32-1, x2);
                }while (start<=x2);
            }
        }
        return res;
    }

    public int getValueByBit(int start, int end) {
        int value = 0;
        int count = end -start + 1;
        while (count--!=0) {
            value<<=1;
            value^=1;
        }
        value<<=(32 - (end -start + 1) - start);
        return value;
    }
}
