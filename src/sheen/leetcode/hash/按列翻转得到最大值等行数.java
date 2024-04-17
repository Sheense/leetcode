package sheen.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 按列翻转得到最大值等行数
 * @Date 2023/5/15 6:43 下午
 * @Created by sheen
 * @Description TODO
 */
public class 按列翻转得到最大值等行数 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < matrix.length; i++) {
            String line = "";
            for(int j = 0; j < matrix[0].length; j++) {
                line += matrix[i][j];
            }
            map.put(line, map.getOrDefault(line, 0) + 1);
        }

        int res = 0;
        for(String key : map.keySet()) {
            String nextKey = "";
            for(int i = 0; i < key.length(); i++) {
                if(key.charAt(i) == '0') {
                    nextKey += "1";
                }else {
                    nextKey += "0";
                }
            }
            res = Math.max(res, map.get(key) + map.getOrDefault(nextKey, 0));
        }
        return res;
    }
}
