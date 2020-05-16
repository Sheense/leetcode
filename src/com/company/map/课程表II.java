package com.company.map;

import com.company.util.ArrayUtils;

import java.lang.reflect.Array;
import java.util.*;

public class 课程表II {
    public static void main(String[] args) {
        课程表II s = new 课程表II();
        ArrayUtils.print(s.findOrder(1,new int[0][0]));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
                        if(index==res.length) return res;
                        queue.offer(pre);
                    }
                }
            }
        }
        if(index==res.length) return res;
        return new int[0];
    }

}
