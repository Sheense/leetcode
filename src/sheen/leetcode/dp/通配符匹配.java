package sheen.leetcode.dp;

import java.util.Scanner;

public class 通配符匹配 {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        String s = scan.next();
        String p = scan.next();
        char[] stringChars = s.toCharArray();
        char[] patternChars = p.toCharArray();
        boolean dp[][] = new boolean[stringChars.length][patternChars.length];
        boolean pEmpty[] = new boolean[patternChars.length];
        for(int i=0;i<pEmpty.length;i++) {
            if(patternChars[i]=='*') pEmpty[i]=true;
            else break;
        }
        for(int i=0; i<stringChars.length; i++) {
            if(i==0) {
                dp[i][0] = patternChars[0] == '*' || patternChars[0] == '?' || patternChars[0] == stringChars[0] ? true : false;
            }
            if(patternChars[0] == '*') dp[i][0] = true;
        }
        for(int i=0; i<stringChars.length;i++) {
            for(int j=1; j<patternChars.length; j++) {
                if(stringChars[i] == patternChars[j] || patternChars[j] == '?' ) {
                    dp[i][j] = i-1>=0&&j-1>=0 ? dp[i-1][j-1] : pEmpty[j-1];
                } else if(patternChars[j]=='*'){
                    dp[i][j] = dp[i][j-1] ||  (i-1>=0 ? dp[i-1][j]:pEmpty[j]);
                }
            }
        }
        for(int i=0;i<stringChars.length;i++){
            for(int j=0;j<patternChars.length;j++)
                System.out.print(dp[i][j]+" ");
            System.out.println();
        }
        System.out.println(dp[stringChars.length-1][patternChars.length-1]);
    }

    public boolean isMatch(String s, String p) {

        if(p==null || s==null) return false;
        if(p.equals(s)) return true;
        if(p.equals("") ) return false;

        char[] patternChars = p.toCharArray();
        boolean pEmpty[] = new boolean[patternChars.length];
        for(int i=0;i<pEmpty.length;i++) {
            if(patternChars[i]=='*') pEmpty[i]=true;
            else break;
        }
        if(s.equals("")) return pEmpty[patternChars.length-1];

        char[] stringChars = s.toCharArray();
        boolean dp[][] = new boolean[stringChars.length][patternChars.length];
        for(int i=0; i<stringChars.length; i++) {
            if(i==0) {
                dp[i][0] = patternChars[0] == '*' || patternChars[0] == '?' || patternChars[0] == stringChars[0] ? true : false;
            }
            if(patternChars[0] == '*') dp[i][0] = true;
        }
        for(int i=0; i<stringChars.length;i++) {
            for(int j=1; j<patternChars.length; j++) {
                if(stringChars[i] == patternChars[j] || patternChars[j] == '?' ) {
                    dp[i][j] = i-1>=0&&j-1>=0 ? dp[i-1][j-1] : pEmpty[j-1];
                } else if(patternChars[j]=='*'){
                    dp[i][j] = dp[i][j-1] ||  (i-1>=0 ? dp[i-1][j]:pEmpty[j]);
                }
            }
        }
        return dp[stringChars.length-1][patternChars.length-1];
    }
}