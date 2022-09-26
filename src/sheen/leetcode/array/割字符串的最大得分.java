package sheen.leetcode.array;

/**
 * @Classname 割字符串的最大得分
 * @Date 2022/8/14 12:12 上午
 * @Created by sheen
 * @Description TODO
 */
public class 割字符串的最大得分 {
    public static void main(String[] args) {
        割字符串的最大得分 s= new 割字符串的最大得分();
        System.out.println(s.maxScore("01001"));
    }
    public int maxScore(String s) {
        if(s.length() == 2) {
            if(s.equals("11")) {
                return 1;
            }else if(s.equals("01")) {
                return 2;
            }else if(s.equals("10")) {
                return 0;
            }else {
                return 1;
            }
        }
        int[] one = new int[s.length()];
        int[] zero = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                zero[i] = i == 0 ? 1 : zero[i - 1] + 1;
            }else {
                zero[i] = i == 0 ? 0 : zero[i - 1];
            }

            if(s.charAt(s.length() - i - 1) == '1') {
                one[s.length() - i - 1] = s.length() - i - 1 == s.length() - 1 ? 1 : one[s.length() - i] + 1;
            }else {
                one[s.length() - i - 1] = s.length() - i - 1 == s.length() - 1 ? 0 : one[s.length() - i];
            }
        }

        int max = 0;
        for(int i = 1; i < s.length() - 1; i++) {
            int num = zero[i - 1] + 1 + one[i+1];
            max = Math.max(num, max);
        }

        return max;
    }
}
