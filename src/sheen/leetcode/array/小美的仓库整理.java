package sheen.leetcode.array;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Classname 小美的仓库整理
 * @Date 2021/8/29 9:34 下午
 * @Created by sheen
 * @Description TODO
 */
public class 小美的仓库整理 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.valueOf(scanner.nextLine());
        String[] str1 = scanner.nextLine().split(" ");
        String[] str2 = scanner.nextLine().split(" ");
        int[] w = new int[size];
        int[] poll = new int[size];
        int[] all = new int[size];
        for(int i = 0; i < size; i++) {
            w[i] = Integer.valueOf(str1[i]);
            poll[i] = Integer.valueOf(str2[i]);
            if(i == 0) {
                all[i] = w[i];
            }else {
                all[i] = w[i] + all[i-1];
            }
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(-1);
        treeSet.add(size);
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((o1, o2) -> o2 - o1);
        treeMap.put(all[size - 1], 1);
        int[] res = new int[size];
        for(int i = 0; i < poll.length; i++) {
            int point = poll[i] - 1;
            Integer left = treeSet.floor(point);
            Integer right = treeSet.ceiling(point);
            if(point != 0) {
                int leftAll = left == -1 ? all[point - 1] : all[point - 1] - all[left];
                treeMap.put(leftAll, treeMap.getOrDefault(leftAll, 0) + 1);
            }
            int rightAll = all[right - 1] - all[point];
            int remove = left == -1 ? all[right-1] : all[right - 1] - all[left];
            if(treeMap.get(remove) == 1) {
                treeMap.remove(remove);
            }else {
                treeMap.put(remove, treeMap.get(remove) - 1);
            }
            treeMap.put(rightAll, treeMap.getOrDefault(rightAll, 0) + 1);
            treeSet.add(point);
            res[i] = treeMap.firstKey();
        }
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
