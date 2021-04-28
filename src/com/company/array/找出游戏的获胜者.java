package com.company.array;

import java.util.LinkedList;
import java.util.List;

public class 找出游戏的获胜者 {
    public static void main(String[] args) {
        找出游戏的获胜者 s = new 找出游戏的获胜者();
        System.out.println(s.findTheWinner(5,2));
    }
    public int findTheWinner(int n, int k) {
        List<Integer> linked = new LinkedList<>();
        for(int i=0;i<n;i++) {
            linked.add(i+1);
        }
        int res = 0;
        while (linked.size() != 1) {
            int index = (res + k-1)%linked.size();
            res = (index) % linked.size();
            linked.remove(index);
        }
        return linked.get(0);
    }
}
