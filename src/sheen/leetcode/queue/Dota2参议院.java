package sheen.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2参议院 {
    public static void main(String[] args) {
        Dota2参议院 s = new Dota2参议院();
        System.out.println(s.predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }
    public String predictPartyVictory(String senate) {
        Queue<Integer> r_queue = new LinkedList<>();
        Queue<Integer> d_queue = new LinkedList<>();
        for(int i=0;i<senate.length();i++) {
            if(senate.charAt(i)=='R') {
                r_queue.offer(i);
            } else {
                d_queue.offer(i);
            }
        }
        while(!r_queue.isEmpty()&&!d_queue.isEmpty()) {
            if(r_queue.peek()<d_queue.peek()) {
                r_queue.offer(r_queue.peek()+senate.length());
            }else {
                d_queue.offer(d_queue.peek()+senate.length());
            }
            d_queue.poll();
            r_queue.poll();
        }
        if(d_queue.isEmpty()) return "Radiant";
        else return "Dire";
    }
}
