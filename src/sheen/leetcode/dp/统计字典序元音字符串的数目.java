package sheen.leetcode.dp;

public class 统计字典序元音字符串的数目 {
    public int countVowelStrings(int n) {
        int dp[] = new int[5];
        for(int i=0;i<n;i++) {
            int[] temp = new int[5];
            for(int j=0;j<5;j++) {
                if(i == 0) temp[j] = 1;
                else {
                    for(int z = j;z>=0;z--) {
                        temp[j] += dp[z];
                    }
                }
            }
            dp = temp;
        }
        int res = 0;
        for(int j=0;j<5;j++) {
            res += dp[j];
        }
        return res;
    }
}
