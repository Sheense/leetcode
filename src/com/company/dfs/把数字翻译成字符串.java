package com.company.dfs;

public class 把数字翻译成字符串 {

    public static void main(String[] args) {
        把数字翻译成字符串 s = new 把数字翻译成字符串();
        System.out.println(s.translateNum(506));
    }
    public int translateNum(int num) {
        return dfs(String.valueOf(num),0,0);
    }

    public int dfs(String string,int start,int num) {
        if(start==string.length()-1||start==string.length()) {
            ++num;
            return num;
        }
        int res = num;
        for(int i=1;i<=2&&start+i<=string.length();i++){
            if(i==2&&Integer.parseInt(string.substring(start,start+i))>25) {
                continue;
            }
            res = dfs(string, start+i,res);
            if(i==1&&string.substring(start,start+1).equals("0")){
                break;
            }
        }
        return res;
    }
}
