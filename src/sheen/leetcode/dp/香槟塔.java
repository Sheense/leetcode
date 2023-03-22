package sheen.leetcode.dp;

/**
 * @Classname 香槟塔
 * @Date 2022/11/20 1:22 上午
 * @Created by sheen
 * @Description TODO
 */
public class 香槟塔 {
    public static void main(String[] args) {
        香槟塔 s = new 香槟塔();
        System.out.println(s.champagneTower(1, 1, 1));
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] row = {poured};
        for(int i = 1; i <= query_row; i++) {
            double[] nextRow = new double[i + 1];
            for(int j = 0; j < nextRow.length - 1; j++) {
                nextRow[j] = (row[j] - 1) / 2 < 0 ? 0 : (row[j] - 1) / 2 ;
                if(j > 0) {
                    nextRow[j] += ((row[j - 1] - 1) / 2 < 0 ? 0 : (row[j - 1] - 1) / 2);
                }
            }
            nextRow[nextRow.length - 1] += ((row[nextRow.length - 2] - 1) / 2 < 0 ? 0 : (row[nextRow.length - 2] - 1) / 2);
            row = nextRow;
        }

        return Math.min(1, row[query_glass]);
    }
}
