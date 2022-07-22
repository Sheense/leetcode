package sheen.leetcode.sort;

import java.util.*;

public class H指数 {
    public int hIndex(int[] citations) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < citations.length; i++) {
            map.put(citations[i], map.getOrDefault(citations[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int res = 0;
        int count = 0;
        for(int i = list.size() - 1; i >= 0; i--) {
            count += map.get(list.get(i));
            if(list.get(i) >= count) {
                res = Math.max(count, res);
            }else {
                int copyCount = count;
                int time = map.get(list.get(i));
                while (time != 0 && copyCount > list.get(i))  {
                   time--;
                   copyCount--;
                }
                if(time != 0) {
                    res = Math.max(res, copyCount);
                }
            }
        }
        return res;
    }
}
