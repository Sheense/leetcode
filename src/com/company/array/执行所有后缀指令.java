package com.company.array;

/**
 * @Classname 执行所有后缀指令
 * @Date 2021/12/26 11:21 上午
 * @Created by sheen
 * @Description TODO
 */
public class 执行所有后缀指令 {
    public static void main(String[] args) {
        执行所有后缀指令 s = new 执行所有后缀指令();
        System.out.println(s.executeInstructions(3, new int[]{0,1}, "RRDDLU"));
    }
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int [] res = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            int x = startPos[0];
            int y = startPos[1];
            for(int j = i; j < s.length(); j++) {
                switch (s.charAt(j)) {
                    case 'R': y++; break;
                    case 'L': y--; break;
                    case 'U': x--; break;
                    case 'D': x++; break;
                }
                if(x > n - 1 || x < 0 || y > n - 1 || y < 0) {
                    res[i] = j - i;
                    break;
                }
                if(j == s.length() - 1) {
                    res[i] = j - i + 1;
                    break;
                }
            }
        }
        return res;
    }
}
