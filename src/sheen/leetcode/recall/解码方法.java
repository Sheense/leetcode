package sheen.leetcode.recall;

public class 解码方法 {
    public static void main(String[] args) {
        解码方法 s = new 解码方法();
        System.out.println(s.numDecodings("100"));
    }

    public int numDecodings(String s) {
        if(s.length()==0||s.charAt(0)=='0') return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for(int i=1;i<s.length();i++) {
            if(i==1) {
                if(s.charAt(1)=='0') {
                    if(Integer.parseInt(s.substring(0,2))<=26) {
                        dp[1] = 1;
                    } else {
                        dp[1] = 0;
                    }
                }
                else {
                    int num = Integer.parseInt(s.substring(0,2));
                    if(num<=26){
                        dp[1] = 2;
                    }else {
                        dp[1] = 1;
                    }
                }
                continue;
            }
            int times = 0;
            if(s.charAt(i)!='0') times += dp[i-1];
            if(s.charAt(i-1)!='0'&&Integer.parseInt(s.substring(i-1,i+1))<=26){
                times+=dp[i-2];
            }
            dp[i] = times;
        }
        return dp[s.length()-1];
    }

}
