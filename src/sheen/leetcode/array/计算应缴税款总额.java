package sheen.leetcode.array;

/**
 * @Classname 计算应缴税款总额
 * @Date 2023/1/23 3:36 下午
 * @Created by sheen
 * @Description TODO
 */
public class 计算应缴税款总额 {
    public double calculateTax(int[][] brackets, int income) {
        double res = 0;
        int i = 0;
        while (income > 0) {
            if(i == 0) {
                double v = Math.min(income, brackets[i][0]);
                res += v * brackets[i][1] * 0.01;
                income -= v;
            }else {
                double v = Math.min(income, brackets[i][0] - brackets[i - 1][0]);
                res += v * brackets[i][1] * 0.01;
                income -= v;
            }
            i++;
        }

        return res;
    }
}
