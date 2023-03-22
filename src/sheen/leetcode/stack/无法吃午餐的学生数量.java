package sheen.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname 无法吃午餐的学生数量
 * @Date 2022/10/19 12:23 上午
 * @Created by sheen
 * @Description TODO
 */
public class 无法吃午餐的学生数量 {
    public int countStudents(int[] students, int[] sandwiches) {
        int index = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < students.length; i++) queue.offer(students[i]);
        while (index < sandwiches.length) {
           int size = queue.size();
           int begin = size;
           while (size -- != 0 && index < sandwiches.length) {
               int v = queue.poll();
               if(sandwiches[index] == v) {
                   index++;
               }else {
                   queue.offer(v);
               }
           }
           if(begin == queue.size()) {
               return queue.size();
           }
        }
        return 0;
    }
}
