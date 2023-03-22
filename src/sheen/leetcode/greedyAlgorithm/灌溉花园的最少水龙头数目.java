package sheen.leetcode.greedyAlgorithm;

import java.util.PriorityQueue;

/**
 * @Classname 灌溉花园的最少水龙头数目
 * @Date 2023/2/21 12:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 灌溉花园的最少水龙头数目 {


    public static void main(String[] args) {
        灌溉花园的最少水龙头数目 s = new 灌溉花园的最少水龙头数目();
        System.out.println(s.minTaps(8, new int[]{4,0,0,0,4,0,0,0,4}));
    }
    public int minTaps(int n, int[] ranges) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> {
            if(x[0] != y[0]) {
                return x[0] - y[0];
            }

            return y[1] - x[1];
        });

        //将range拆成区间
        for(int i = 0; i < ranges.length; i++) {
            queue.offer(new int[]{i - ranges[i], i + ranges[i]});
        }

        //表示水已经走到哪里了
        int end = 0;
        int res = 0;
        //当前已经选择好的区间的最后一个
        int[] now = null;
        //pre保存待选择的下一个区间
        int[] pre = null;
        while (!queue.isEmpty() && end < n) {
            int[] line = queue.peek();
            if(now == null) {
                if(line[0] > end) {
                    return -1;
                }
                now = line;
                //找到第一个节点，left<=0覆盖范围越远的区间
                while (!queue.isEmpty() && queue.peek()[0] <= end) {
                    int[] item = queue.poll();
                    if(now[1] < item[1]) {
                        now = item;
                    }
                }
                end = now[1];
                res++;
            }else {
                if(now[1] >= line[0]) {
                    if(line[1] >= n) {
                        return res + 1;
                    }

                    //更新最远
                    if(pre == null || line[1] > pre[1]) {
                        pre = line;
                    }
                    queue.poll();
                }else {
                    //前面没有待选的了，接不上now[1]了
                    if(pre == null) {
                        return -1;
                    }
                    end = pre[1];
                    res++;
                    now = pre;
                    pre = null;
                }
            }
        }

        if(end >= n) {
            return res;
        }
        return -1;
    }
}
