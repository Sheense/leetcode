package sheen.leetcode.array;

/**
 * @Classname 保龄球游戏的获胜者
 * @Date 2023/12/27 00:05
 * @Created by sheen
 * @Description TODO
 */
public class 保龄球游戏的获胜者 {
    public int isWinner(int[] player1, int[] player2) {
        int a = getPoint(player1);
        int b = getPoint(player2);
        if(a > b) return 1;
        else if(a < b) return 2;
        return 0;
    }

    public int getPoint(int[] player) {
        int res = 0;
        for(int i = 0; i < player.length; i++) {
            int item = player[i];
            if(i - 1 >= 0 && player[i - 1] == 10) {
                item += player[i];
            }else if(i - 2 >= 0 && player[i - 2] == 10) {
                item += player[i];
            }
            res += item;
        }
        return res;
    }
}
