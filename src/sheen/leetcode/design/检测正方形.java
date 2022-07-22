package sheen.leetcode.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 检测正方形
 * @Date 2022/1/26 12:33 上午
 * @Created by sheen
 * @Description TODO
 */
public class 检测正方形 {
    class DetectSquares {

        private Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        public DetectSquares() {

        }

        public void add(int[] point) {
            Map<Integer, Integer> m = map.computeIfAbsent(point[1], x -> new HashMap<>());
            m.put(point[0], m.getOrDefault(point[0], 0) + 1);
        }

        public int count(int[] point) {
            int res = 0;
            if(!map.containsKey(point[1])) {
                return 0;
            }
            Map<Integer, Integer> m = map.getOrDefault(point[1], new HashMap<>());
            for(Map.Entry<Integer, Map<Integer, Integer>> entry : map.entrySet()) {
                int col = entry.getKey();
                Map<Integer, Integer> value = entry.getValue();
                if(col != point[1]) {
                    int d = col - point[1];
                    res += m.getOrDefault(point[0]+d, 0)
                            * value.getOrDefault(point[0], 0) * value.getOrDefault(point[0] + d, 0);
                    res +=  m.getOrDefault(point[0]-d, 0)
                            * value.getOrDefault(point[0], 0) * value.getOrDefault(point[0] - d, 0);
                }
            }
            return res;
        }
    }
}
