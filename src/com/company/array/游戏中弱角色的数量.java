package com.company.array;

import com.company.util.ArrayUtils;

import java.util.*;

/**
 * @Classname 游戏中弱角色的数量
 * @Date 2021/9/6 12:22 上午
 * @Created by sheen
 * @Description TODO
 */
public class 游戏中弱角色的数量 {
    public static void main(String[] args) {
        游戏中弱角色的数量 s = new 游戏中弱角色的数量();
        System.out.println(s.numberOfWeakCharacters(new int[][]{{1,5},{10,4},{4,3}}));
    }
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> o2[0] - o1[0]);
        TreeSet<Integer> set = new TreeSet<>();
        int i = 0;
        int res = 0;
        while (i < properties.length) {
            int index = i;
            List<Integer> list = new ArrayList<>();
            while (index < properties.length && properties[index][0] == properties[i][0]) {
                list.add(properties[index][1]);
                Integer s = set.higher(properties[index][1]);
                if(s != null) res++;
                index++;
            }
            set.addAll(list);
            i = index;
        }
        return res;
    }
}
