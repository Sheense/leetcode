package sheen.leetcode.math;

import java.util.HashMap;
import java.util.Map;

public class 盒子中小球的最大数量 {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i= lowLimit;i<=highLimit;i++) {
            int item = i;
            int num = 0;
            while(item!=0) {
                num+=(item%10);
                item/=10;
            }
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int max = -1;
        for(int key:map.keySet()) {
            if(map.get(key)>max) {
                max = map.get(key);
            }
        }
        return max;
    }
}
