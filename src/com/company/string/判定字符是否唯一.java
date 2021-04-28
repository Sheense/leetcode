package com.company.string;

public class 判定字符是否唯一 {
    public static void main(String[] args) {
        判定字符是否唯一 s = new 判定字符是否唯一();
        System.out.println(s.isUnique("aaaaaassscf"));
    }
    public boolean isUnique(String astr) {
        if(astr.length() == 0) return true;
        int all = 1<<(astr.charAt(0) - 'a');
        for(int i=1;i<astr.length();i++) {
            int a = 1<<(astr.charAt(i) - 'a');
            if ((all & a) != 0 ) {
                return false;
            }
            all ^= a;
        }
        return true;
    }
}
