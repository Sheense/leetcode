package com.company.string;

public class 机器人能否返回原点 {
    public boolean judgeCircle(String moves) {
        int [] arr = new int[4];
        for(int i=0;i<moves.length();i++) {
            switch (moves.charAt(i)){
                case 'L':{
                    arr[0]++;
                    break;
                }
                case 'R':{
                    arr[1]++;
                    break;
                }
                case 'U':{
                    arr[2]++;
                    break;
                }
                case 'D':{
                    arr[3]++;
                    break;
                }
            }
        }
        if(arr[0]!=arr[1]) return false;
        if(arr[2]!=arr[3]) return false;
        return true;
    }
}
