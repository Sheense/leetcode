package com.company.window;

/**
 * @Classname 考试的最大困扰度
 * @Date 2022/3/29 12:18 上午
 * @Created by sheen
 * @Description TODO
 */
public class 考试的最大困扰度 {
    public static void main(String[] args) {
        考试的最大困扰度 s = new 考试的最大困扰度();
        System.out.println(s.maxConsecutiveAnswers("TTFTTFTT", 1));
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(window(answerKey, k, 'T'), window(answerKey, k, 'F'));
    }

    public int window(String answerKey, int k, char answer) {
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < answerKey.length()) {
            while (right < answerKey.length()) {
                if(answerKey.charAt(right) != answer) {
                    if(k - 1 < 0) {
                        break;
                    }
                    k--;
                }
                right++;
            }
            res = Math.max(res, right - left);
            while (left < right && k <= 0) {
                if(answerKey.charAt(left) != answer) {
                    k++;
                }
                left++;
            }
        }
        return res;
    }
}
