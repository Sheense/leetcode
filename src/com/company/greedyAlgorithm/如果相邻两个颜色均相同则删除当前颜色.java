package com.company.greedyAlgorithm;

/**
 * @Classname 如果相邻两个颜色均相同则删除当前颜色
 * @Date 2022/3/22 12:10 上午
 * @Created by sheen
 * @Description TODO
 */
public class 如果相邻两个颜色均相同则删除当前颜色 {
    public boolean winnerOfGame(String colors) {
        int a = 0;
        int b = 0;
        int i = 0;
        while (i < colors.length()) {
            int index = i;
            while (index < colors.length() && colors.charAt(index) == colors.charAt(i)) {
                index++;
            }
            int count = index - i;
            if(count >= 3) {
                if(colors.charAt(i) == 'A') {
                    a += count - 2;
                }else {
                    b += count - 2;
                }
            }
            i = index;
        }
        return a > b;
    }
}
