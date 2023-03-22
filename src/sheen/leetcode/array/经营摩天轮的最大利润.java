package sheen.leetcode.array;

/**
 * @Classname 经营摩天轮的最大利润
 * @Date 2023/3/5 12:19 上午
 * @Created by sheen
 * @Description TODO
 */
public class 经营摩天轮的最大利润 {
    public static void main(String[] args) {
        经营摩天轮的最大利润 s = new 经营摩天轮的最大利润();
        System.out.println(s.minOperationsMaxProfit(new int[]{5,0,0,0,0,30}, 5, 5));
    }
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int yu = 0;
        int count = 0;
        int max = 0;
        int total = 0;

        int res = -1;
        for(int i = 0; i < customers.length; i++) {
            yu += customers[i];
            total += (boardingCost * Math.min(yu, 4)- runningCost);
            yu -= Math.min(yu, 4);
            count++;
            if(total > max) {
                max = total;
                res = count;
            }
        }


        while (yu > 0) {
            total += (Math.min(4, yu) * boardingCost - runningCost);
            yu -= Math.min(4, yu);
            count++;
            if(total > max) {
                max = total;
                res = count;
            }
        }

        return res;
    }
}
