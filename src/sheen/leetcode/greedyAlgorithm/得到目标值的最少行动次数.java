package sheen.leetcode.greedyAlgorithm;

import java.util.Map;

/**
 * @Classname 得到目标值的最少行动次数
 * @Date 2022/1/16 10:42 上午
 * @Created by sheen
 * @Description TODO
 */
public class 得到目标值的最少行动次数 {
    public static void main(String[] args) {
        得到目标值的最少行动次数 s = new 得到目标值的最少行动次数();
        System.out.println(s.minMoves(10, 2));
    }

    public int minMoves(int target, int maxDoubles) {
        int res = 0;
        while (target > 1 && maxDoubles > 0) {

            if(target % 2 == 0) {
                target /= 2;
                maxDoubles --;
            }else {
                target --;
            }
            res++;
        }
        if(target > 1) {
            res += target - 1;
        }
        return res;
    }

    public int recall(int target, long maxDoubles, int start, Map<Long, Integer> map) {
        if(start > target) {
            return Integer.MAX_VALUE - 1;
        }
        if(start == target) {
            return 0;
        }

        if(map.containsKey(start)) {
            return map.get(start);
        }

        int min = Integer.MAX_VALUE;
        if(maxDoubles != 0) {
            min = recall(target, maxDoubles - 1,start * 2, map) + 1;
        }
        min = Math.min(recall(target, maxDoubles, start + 1, map) + 1, min);
        map.put(maxDoubles, min);
        return min;
    }
}
