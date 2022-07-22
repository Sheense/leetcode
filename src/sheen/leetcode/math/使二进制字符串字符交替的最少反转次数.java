package sheen.leetcode.math;

public class 使二进制字符串字符交替的最少反转次数 {
    public static void main(String[] args) {
        使二进制字符串字符交替的最少反转次数 s = new 使二进制字符串字符交替的最少反转次数();
        System.out.println(s.minFlips("10001100101000000"));
    }
    public int minFlips(String s) {
        int[][] cnt = new int[2][2]; //二维的0代表偶数，1代表奇数
        for(int i = 0;i<s.length();i++) {
            if(s.charAt(i) == '0') {
                cnt[0][i&1] ++;
            }else {
                cnt[1][i&1] ++;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                res = Math.min(Math.min(res, cnt[0][1] + cnt[1][0]), cnt[0][0] + cnt[1][1]);
            } else {
                res = Math.min(Math.min(res, cnt[1][1] + cnt[0][0]), cnt[1][0] + cnt[0][1]);
            }
            if (s.length() % 2 == 1) {
                if (s.charAt(i) == '1') {
                    cnt[1][0]--;
                } else {
                    cnt[0][0]--;
                }
            }
            cnt[0][0] = cnt[0][1] + cnt[0][0];
            cnt[0][1] = cnt[0][0] - cnt[0][1];
            cnt[0][0] = cnt[0][0] - cnt[0][1];

            cnt[1][0] = cnt[1][1] + cnt[1][0];
            cnt[1][1] = cnt[1][0] - cnt[1][1];
            cnt[1][0] = cnt[1][0] - cnt[1][1];
            if (s.length() % 2 == 1) {
                if (s.charAt(i) == '1') {
                    cnt[1][0] ++;
                } else {
                    cnt[0][0] ++;
                }
            }
        }
        return res;
    }
}
