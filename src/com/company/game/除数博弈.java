package com.company.game;

public class 除数博弈 {
    public static void main(String[] args) {
        除数博弈 s = new 除数博弈();
        System.out.println(s.divisorGame(1000));
    }
    public boolean divisorGame(int N) {
        if(N==1) return false;
        if(N==2) return true;
        boolean[] b = new boolean[N];
        b[0] = false;
        b[1] = true;
        for(int i=2;i<N;i++) {
            boolean flag = false;
            for(int j=1;j<=(i+1)/2;j++) {
                if((i+1)%j==0&&!b[i-j]) {
                    flag = true;
                    break;
                }
            }
            b[i] = flag;
        }
        return b[N-1];
    }
}
