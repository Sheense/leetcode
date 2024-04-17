package sheen.leetcode.recall;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 切披萨的方案数
 * @Date 2023/8/17 00:23
 * @Created by sheen
 * @Description TODO
 */
public class 切披萨的方案数 {
    public static void main(String[] args) {
        切披萨的方案数 s = new 切披萨的方案数();
        System.out.println(s.ways(new String[]{"A..","AAA","..."}, 3));
    }
        public int ways(String[] pizza, int k) {
            int[][] row = new int[pizza.length][pizza[0].length()];
            int[][] col = new int[pizza.length][pizza[0].length()];
            for(int i = 0; i < row.length; i++) {
                for(int j = 0; j < row[i].length; j++) {
                    row[i][j] = pizza[i].charAt(j) == 'A' ? 1 : 0;
                    if(j > 0) {
                        row[i][j] += row[i][j - 1];
                    }
                }
            }

            for(int i = 0; i < col[0].length; i++) {
                for(int j = 0; j < col.length; j++) {
                    col[j][i] = pizza[j].charAt(i) == 'A' ? 1 : 0;
                    if(j > 0) {
                        col[j][i] += col[j - 1][i];
                    }
                }
            }
            return recall(row, col, new int[]{0, 0}, new HashMap<>(), k - 1);
        }

        private int mod = (int)Math.pow(10 , 9) + 7;

        public int recall(int[][] row, int[][] col, int[] start, Map<String, Integer> map, int k) {
            int m = row[0].length;
            String key = buildKey(start, m, k);
            if(map.containsKey(key)) {
                return map.get(key);
            }

            int x = start[0];
            int y = start[1];
            if(k == 0) {
                for(int i = x; i < row.length; i++) {
                    int c = row[i][m - 1] - (y == 0 ? 0 : row[i][y - 1]);
                    if(c > 0) {
                        map.put(key, 1);
                        return 1;
                    }
                }
                map.put(key, 0);
                return 0;
            }

            if(x == row.length - 1 && y == row[0].length - 1) {
                return 0;
            }

            int res = 0;
            int c = 0;
            for(int i = x; i < row.length - 1; i++) {
                c += row[i][m - 1] - (y == 0 ? 0 : row[i][y - 1]);
                if(c > 0) {
                    res += recall(row, col, new int[]{i + 1, y}, map, k - 1);
                    res %= mod;
                }
            }

            c = 0;
            if(y < m - 1) {
                for(int i = y; i < m - 1; i++) {
                    c += col[row.length - 1][i] - (x == 0 ? 0 : col[x - 1][i]);
                    if(c > 0) {
                        res += recall(row, col, new int[]{x, i + 1}, map, k - 1);
                        res %= mod;
                    }
                }
            }
            map.put(key, res);
            return res;
        }

        public String buildKey(int[] start, int m, int k) {
            int a = start[0] * m + start[1];
            return a + "#" + k;
        }
}
