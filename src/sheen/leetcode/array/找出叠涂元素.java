package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 找出叠涂元素
 * @Date 2023/12/1 00:36
 * @Created by sheen
 * @Description TODO
 */
public class 找出叠涂元素 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];

        for(int i = 0; i < arr.length; i++) {
            int[] item = map.get(arr[i]);
            row[item[0]]++;
            col[item[1]]++;
            if(row[item[0]] == mat[0].length || col[item[1]] == mat.length) {
                return i;
            }
        }
        return -1;
    }
}
