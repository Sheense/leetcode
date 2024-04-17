package sheen.leetcode.bitOperation;

/**
 * @Classname 被列覆盖的最多行数
 * @Date 2024/1/4 00:43
 * @Created by sheen
 * @Description TODO
 */
public class 被列覆盖的最多行数 {
    public static void main(String[] args) {
        被列覆盖的最多行数 s = new 被列覆盖的最多行数();
        System.out.println(s.maximumRows(new int[][]{{1},{0}}, 1));
    }
    public int maximumRows(int[][] matrix, int numSelect) {
        int col = matrix[0].length;
        int max = 0;
        for(int i = 0; i < (1 << col); i++) {
            int item = 0;
            int count = count(i);
            if(count == numSelect) {
                for(int j = 0; j < matrix.length; j++) {
                    if(check(matrix[j], i)) {
                        item++;
                    }
                }
            }
            max = Math.max(max, item);
        }
        return max;
    }

    public boolean check(int[] value, int i) {
        for(int j = value.length - 1; j >= 0; j--) {
            int v = i & 1;
            if(value[j] == 1 && v == 0) {
                return false;
            }
                i >>= 1;
        }
        return true;
    }

    public int count(int v) {
        int res = 0;
        while (v != 0) {
            res += (v & 1);
            v >>= 1;
        }
        return res;
    }
}
