package com.company.string;

public class 交错字符串 {
    public boolean isInterleave(String s1, String s2, String s3) {
        return interleave(s1.toCharArray(),0,s2.toCharArray(),0,s3.toCharArray(),0);
    }
    private boolean interleave(char[] s1,int index_1,char[] s2,int index_2,char[] s3,int index_3) {
        if(index_3==s3.length&&s1.length==index_1&&s2.length==index_2) return true;
        if(index_3==s3.length&&(s1.length>index_1||s2.length>index_2)) return false;
        if(index_3<s3.length&&s1.length==index_1&&s2.length==index_2) return false;
        boolean res = false;
        if(index_1<s1.length&&s1[index_1]==s3[index_3]) {
            res = interleave(s1,index_1+1,s2,index_2,s3,index_3+1);
        }
        if(!res) {
            if(index_2<s2.length&&s2[index_2]==s3[index_3]) {
                res = interleave(s1,index_1,s2,index_2+1,s3,index_3+1);
            }
        }
        return res;
    }
}
