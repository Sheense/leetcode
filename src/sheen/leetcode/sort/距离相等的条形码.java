package sheen.leetcode.sort;

import sheen.leetcode.util.ArrayUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Classname 距离相等的条形码
 * @Date 2021/9/12 2:49 下午
 * @Created by sheen
 * @Description TODO
 */
public class 距离相等的条形码 {
    public static void main(String[] args) {
        距离相等的条形码 a = new 距离相等的条形码();
        ArrayUtils.print(a.rearrangeBarcodes(new int[]    {51,83,51,40,51,40,51,40,83,40,83,83,51,40,40,51,51,51,40,40,40,83,51,51,40,51,51,40,40,51,51,40,51,51,51,40,83,40,40,83,51,51,51,40,40,40,51,51,83,83,40,51,51,40,40,40,51,40,83,40,83,40,83,40,51,51,40,51,51,51,51,40,51,83,51,83,51,51,40,51,40,51,40,51,40,40,51,51,51,40,51,83,51,51,51,40,51,51,40,40}
        ));
    }
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < barcodes.length; i++) {
            map.put(barcodes[i], map.getOrDefault(barcodes[i], 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for(int key:map.keySet()) {
            queue.offer(key);
        }
        int res[] = new int[barcodes.length];
        int i = 0;
        while (!queue.isEmpty()) {
            int a = queue.poll();
            if(queue.isEmpty()) {
                res[i] = a;
                break;
            }
            int b = queue.poll();
            while (map.get(a) != 0 && i < res.length && map.get(b) != 0) {
                res[i++] = a;
                map.put(a, map.get(a) - 1);
                res[i++] = b;
                map.put(b, map.get(b) - 1);
                if(!queue.isEmpty() && map.get(a) < map.get(queue.peek())) {
                    break;
                }
            }
            if(map.get(b) != 0) {
                queue.offer(b);
            }
            if(map.get(a) != 0) {
                queue.offer(a);
            }
        }
        return res;
    }
}
