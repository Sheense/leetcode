package sheen.leetcode.dp;

import java.util.Arrays;

/**
 * @Classname 猫和老鼠
 * @Date 2022/1/4 12:25 上午
 * @Created by sheen
 * @Description TODO
 */
public class 猫和老鼠 {
    private int MOUSE_WIN = 1;
    private int CAT_WIN = 2;
    private int DRAW = 3;
    private int[][] graph;
    private int[][][] dp;
    private int n;
    public int catMouseGame(int[][] graph) {
        this.graph = graph;
        this.n = graph.length;
        dp = new int[graph.length][graph.length][2 * graph.length];
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return getResult(1, 2, 0);
    }

    public int getResult(int mouse, int cat, int turns) {
        if(n * 2 == turns) return DRAW;
        if(dp[mouse][cat][turns] < 0) {
            if(mouse == 0){
                return MOUSE_WIN;
            }else if(mouse == cat) {
                return CAT_WIN;
            }else {
                getNextResult(mouse, cat, turns);
            }
        }
        return dp[mouse][cat][turns];
    }

    public void getNextResult(int mouse, int cat, int turns) {
        int curMove = turns % 2 == 0 ? mouse : cat;
        int defaultRes = curMove == mouse ? CAT_WIN : MOUSE_WIN;
        int res = defaultRes;
        int[] nextPos = graph[curMove];
        for(int next : nextPos) {
            if(curMove == cat && next == 0) {
                continue;
            }
            int nextMouse = curMove == mouse ? next : mouse;
            int nextCat = curMove == cat ? next : cat;
            int nextRes = getResult(nextMouse, nextCat, turns + 1);
            if(nextRes != defaultRes) {
                res = nextRes;
                if(nextRes != DRAW) {
                    break;
                }
            }
        }
        dp[mouse][cat][turns] = res;
    }
}
