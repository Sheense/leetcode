package sheen.leetcode.GeminiNeedle;

public class 平方数之和 {

    public static void main(String[] args) {
        平方数之和 s = new 平方数之和();
        System.out.println(s.judgeSquareSum(16));
    }

    public boolean judgeSquareSum(int c) {
        int end = (int)Math.sqrt(c);
        int start = 1;
        while(start<=end) {
            if(Math.pow(start,2)+Math.pow(end,2) == c) {
                return true;
            }else if(Math.pow(start,2)+Math.pow(end,2)> c) {
                end--;
            }else {
                start++;
            }
        }
        return false;
    }
}
