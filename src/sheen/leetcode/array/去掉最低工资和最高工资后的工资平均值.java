package sheen.leetcode.array;

import java.util.Arrays;

/**
 * @Classname 去掉最低工资和最高工资后的工资平均值
 * @Date 2024/5/3 00:01
 * @Created by sheen
 * @Description TODO
 */
public class 去掉最低工资和最高工资后的工资平均值 {
    public double average(int[] salary) {
        Arrays.sort(salary);
        double res = 0;
        for(int i = 1; i < salary.length - 1; i++) {
            res += salary[i];
        }

        return res / (salary.length - 2);
    }
}
