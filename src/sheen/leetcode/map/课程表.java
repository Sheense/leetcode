package sheen.leetcode.map;

import java.util.LinkedList;
import java.util.Queue;

public class 课程表 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] du = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++) {
            int last = prerequisites[i][0];
            du[last]++;
        }
        int[] res = new int[numCourses];
        int index =0 ;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(du[i]==0){
                res[index++] = i;
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            int value = queue.poll();
            for(int i=0;i<prerequisites.length;i++) {
                if(prerequisites[i][1]==value) {
                    int pre = prerequisites[i][0];
                    du[pre]--;
                    if(du[pre]==0) {
                        res[index++] = pre;
                        if(index==res.length) return true;
                        queue.offer(pre);
                    }
                }
            }
        }
        if(index==res.length) return true;
        return false;
    }
}
