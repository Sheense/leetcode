package com.company.array;

public class 找到需要补充粉笔的学生编号 {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) {
            sum += chalk[i];
        }

        long yu = k % sum;
        for (int i = 0; i < chalk.length; i++) {
            if (yu < chalk[i]) return i;
            yu -= chalk[i];
        }
        return -1;
    }
}
