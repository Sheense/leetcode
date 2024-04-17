package sheen.leetcode.array;

/**
 * @Classname 宝石补给
 * @Date 2023/9/15 00:23
 * @Created by sheen
 * @Description TODO
 */
public class 宝石补给 {
    public static void main(String[] args) {
        宝石补给 s = new 宝石补给();
        System.out.println(s.giveGem(new int[]{0, 2,5,4}, new int[][]{{3,2},{3,2},{1,3},{0,2},{3,0},{3,1},{0,3},{2,1},
                {3,0}}));
    }
    public int giveGem(int[] gem, int[][] operations) {
        int max = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < operations.length; i++) {
            gem[operations[i][1]] += gem[operations[i][0]] / 2;
            gem[operations[i][0]] = gem[operations[i][0]] - (gem[operations[i][0]] / 2);
        }

        for(int i = 0; i < gem.length; i++) {
            max = Math.max(max, gem[i]);
            min = Math.min(min, gem[i]);
        }
        return max - min;
    }
}
