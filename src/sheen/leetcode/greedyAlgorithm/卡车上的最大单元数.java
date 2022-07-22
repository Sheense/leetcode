package sheen.leetcode.greedyAlgorithm;

import java.util.PriorityQueue;
import java.util.Queue;

public class 卡车上的最大单元数 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Queue<int[]> queue = new PriorityQueue<>((o1,o2)->o2[1] - o1[1]);
        for(int i=0;i<boxTypes.length;i++) {
            queue.add(boxTypes[i]);
        }
        int res = 0;
        while (truckSize>0&&!queue.isEmpty()) {
            int[] arr = queue.poll();
            int num = Math.min(truckSize, arr[0]);
            res += arr[1] * num;
            truckSize-=num;
        }
        return res;
    }
}
