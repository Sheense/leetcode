package sheen.leetcode.stack;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 可以到达的最远建筑 {

    public static void main(String[] args) {
        可以到达的最远建筑 s = new 可以到达的最远建筑();
        System.out.println(s.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19},10,2));
    }

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>(heights.length, Comparator.reverseOrder());
        int [] map = new int[heights.length];
        for(int i = 1;i<heights.length;i++) {
            map[i] = Math.max(0, heights[i] - heights[i-1]);
        }
        int index = 0;
        while(index<map.length-1) {
            if(map[index+1]==0) {
                index++;
                continue;
            }
            if(bricks-map[index+1]>=0) {
                index++;
                bricks-=map[index];
                maxheap.add(map[index]);
            }else {
                if(ladders>0&&(maxheap.size()>0&&maxheap.peek()+bricks>=heights[index+1])) {
                    int max = maxheap.poll();
                    bricks+=max;
                    bricks-=map[index+1];
                    maxheap.add(map[index+1]);
                    ladders--;
                    index++;
                }else if(ladders>0){
                    ladders--;
                    index++;
                }else break;
            }
        }
        return index;
    }
}
