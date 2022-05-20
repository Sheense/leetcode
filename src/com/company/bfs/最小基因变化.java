package com.company.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Classname 最小基因变化
 * @Date 2022/5/7 12:12 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最小基因变化 {
    public static void main(String[] args) {
        最小基因变化 s = new 最小基因变化();
        System.out.println(s.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"}));
    }
    public int minMutation(String start, String end, String[] bank) {
        char[] arr = {'A', 'G', 'C', 'T'};
        Set<String> set = new HashSet<>();
        for(int i = 0; i < bank.length; i++) set.add(bank[i]);

        if(!set.contains(end)) {
            return -1;
        }
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> check = new HashSet<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size -- != 0) {
                String str = queue.poll();
                if(!check.contains(str)) {
                    check.add(str);
                    if(str.equals(end)) {
                        return count;
                    }
                    for(int i = 0; i < str.length(); i++) {
                        for(int j = 0; j < arr.length; j++) {
                            if(arr[j] != str.charAt(i)) {
                                String newString = "";
                                if(i == 0) {
                                    newString = arr[j] + str.substring(1);
                                }else if(i == str.length() - 1) {
                                    newString = str.substring(0, str.length() - 1) + arr[j];
                                }else {
                                    newString = str.substring(0, i) + arr[j] + str.substring(i + 1);
                                }
                                if(set.contains(newString) && !check.contains(newString)) {
                                    queue.offer(newString);
                                }
                            }
                        }
                    }
                }
            }

            count++;
        }

        return -1;
    }
}
