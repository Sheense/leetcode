package sheen.leetcode.dp;

/**
 * @Classname 最大为N的数字组合
 * @Date 2022/10/18 3:11 下午
 * @Created by sheen
 * @Description TODO
 */
public class 最大为N的数字组合 {
    public static void main(String[] args) {
        最大为N的数字组合 s = new 最大为N的数字组合();
        System.out.println(s.atMostNGivenDigitSet(new String[]{"7"}, 8));
    }
    public int atMostNGivenDigitSet(String[] digits, int n) {

        String num = String.valueOf(n);
        int[][] dp = new int[num.length()][2];
        for(int i = 0; i < num.length(); i++) {
            int index = find(digits, num.charAt(i) - '0');
            if(i == 0) {
                dp[i][0] = index;
            }else {
                dp[i][0] = digits.length + dp[i - 1][0] * digits.length + dp[i - 1][1] * index;
            }

            dp[i][1] = index < digits.length && digits[index].equals(String.valueOf(num.charAt(i))) && (i == 0 || dp[i - 1][1] == 1) ? 1 : 0;
        }

        return dp[num.length() - 1][0] + dp[num.length() - 1][1];
    }

    public int find(String[] digits, int target) {
        int left = 0;
        int right = digits.length - 1;
       while (left <= right) {
           int mid = (left + right) / 2;
           if(Integer.valueOf(digits[mid]) >= target) {
               right = mid - 1;
           }else {
               left = mid + 1;
           }
       }

       return left;
    }
}
