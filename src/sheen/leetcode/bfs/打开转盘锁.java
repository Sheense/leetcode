package sheen.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 打开转盘锁 {

    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < deadends.length; i++) {
            set.add(deadends[i]);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size --!= 0) {
                String num = queue.poll();
                if(num.equals(target)) {
                    return count;
                }
                if(set.contains(num)) {
                   continue;
                }
                set.add(num);
                for(int i = 0; i < num.length(); i++) {
                    int index = num.charAt(i) - '0';
                    String addNum = "";
                    String menuNum = "";
                    if(i == 0) {
                       addNum = addNum(index) + num.substring(i+1);
                       menuNum = menuNum(index) + num.substring(i+1);
                    }else if(i == num.length() - 1) {
                        addNum = num.substring(0, i) +  addNum(index);
                        menuNum = num.substring(0, i) + menuNum(index) ;
                    }else {
                        addNum = num.substring(0, i) + addNum(index) + num.substring(i+1);
                        menuNum = num.substring(0, i) + menuNum(index)+ num.substring(i+1);
                    }
                    queue.offer(addNum);
                    queue.offer(menuNum);
                }
            }
            count++;
        }
        return -1;
    }

    public int addNum(int index) {
        return (index+1) % 10;
    }

    public int menuNum(int index) {
        return (index + 10 - 1) % 10;
    }
}
