package com.company.dp;

public class 地下城游戏 {

    public static void main(String[] args) {
        地下城游戏 s = new 地下城游戏();
        int[][] dungeon = {
                            {0,-3}
        };
        System.out.println(s.calculateMinimumHP(dungeon));
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int index = dungeon.length-2;
        if(dungeon[dungeon.length-1][dungeon[0].length-1]>=0) {
            dungeon[dungeon.length-1][dungeon[0].length-1] = 1;
        }else {
            dungeon[dungeon.length-1][dungeon[0].length-1] = Math.abs(dungeon[dungeon.length-1][dungeon[0].length-1])+1;
        }
        while(index>=0) {
            if(dungeon[index][dungeon[0].length-1]>=0) {
                if(dungeon[index+1][dungeon[0].length-1]==1) {
                    dungeon[index][dungeon[0].length-1] = 1;
                } else {
                    if(dungeon[index][dungeon[0].length-1]>=dungeon[index+1][dungeon[0].length-1]) dungeon[index][dungeon[0].length-1] = 1;
                    else dungeon[index][dungeon[0].length-1] = dungeon[index+1][dungeon[0].length-1] - dungeon[index][dungeon[0].length-1];
                }
            }else {
                dungeon[index][dungeon[0].length-1] = Math.abs(dungeon[index][dungeon[0].length-1]) + dungeon[index+1][dungeon[0].length-1];
            }
            index--;
        }
        index = dungeon[0].length-2;
        while (index>=0) {
            if(dungeon[dungeon.length-1][index]>=0) {
                if(dungeon[dungeon.length-1][index+1]==1) {
                    dungeon[dungeon.length-1][index] = 1;
                } else {
                    if(dungeon[dungeon.length-1][index]>=dungeon[dungeon.length-1][index+1]) dungeon[dungeon.length-1][index] = 1;
                    else dungeon[dungeon.length-1][index] = dungeon[dungeon.length-1][index+1] - dungeon[dungeon.length-1][index];
                }
            }else {
                dungeon[dungeon.length-1][index] = Math.abs(dungeon[dungeon.length-1][index]) + dungeon[dungeon.length-1][index+1];
            }
            index--;
        }
        for(int i=dungeon.length-2;i>=0;i--) {
            for(int j=dungeon[i].length-2;j>=0;j--) {
                int min = dungeon[i+1][j]>dungeon[i][j+1]?dungeon[i][j+1]:dungeon[i+1][j];
                if(dungeon[i][j]>=0) {
                   if(dungeon[i+1][j]!=1&&dungeon[i][j+1]!=1) {
                       if(dungeon[i][j]>=min) dungeon[i][j]= 1;
                       else dungeon[i][j] = min - dungeon[i][j];
                   }else dungeon[i][j] = 1;
                }else {
                    dungeon[i][j] = Math.abs(dungeon[i][j]) + min;
                }
            }
        }
        return dungeon[0][0];
    }

}
