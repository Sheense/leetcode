package sheen.leetcode.string;

/**
 * @Classname 判断国际象棋棋盘中一个格子的颜色
 * @Date 2022/12/8 12:02 上午
 * @Created by sheen
 * @Description TODO
 */
public class 判断国际象棋棋盘中一个格子的颜色 {
    public boolean squareIsWhite(String coordinates) {
        char c1 = coordinates.charAt(0);
        char c2 = coordinates.charAt(1);
        return !(((c1 - 'a') % 2 == 1 && (c2 - '0') % 2 == 0) || ((c1 - 'a') % 2 == 0 && (c2 - '0') % 2 == 1));
    }
}
