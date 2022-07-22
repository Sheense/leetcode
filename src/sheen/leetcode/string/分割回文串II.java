package sheen.leetcode.string;

public class 分割回文串II {

    public static void main(String[] args) {
        分割回文串II s = new  分割回文串II();
        System.out.println(s.minCut("abbab"));
    }
    public int minCut(String s) {
        boolean[][] map = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++) {
            for(int j=0;j+i<s.length();j++) {
                if(i==0) {
                    map[j][j] = true;
                    continue;
                }
                map[j][j+i] = i==1?(s.charAt(j+i)==s.charAt(j)): (s.charAt(j+i)==s.charAt(j)&&map[j+1][j+i-1]);
            }
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;
        for (int i=1; i<s.length(); i++){
            if(map[0][i]) {
                continue;
            }
            dp[i] = dp[i-1] +1;
            for (int j=i-1; j>0; j--){
                if(map[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j-1]+1);
                }
            }
        }
        return dp[s.length()-1];
    }
}
