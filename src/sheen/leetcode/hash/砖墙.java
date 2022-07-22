package sheen.leetcode.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 砖墙 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<wall.size();i++) {
            int now = 0;
            for(int j=0;j<wall.get(i).size()-1;j++) {
                now += wall.get(i).get(j);
                map.put(now, map.getOrDefault(now, 0) + 1);
            }
        }
        int min = wall.size();
        for(int value:map.values()) {
            min = Math.min(min, wall.size() - value);
        }
        return min;
    }
}
