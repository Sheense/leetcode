package sheen.leetcode.greedyAlgorithm;

import java.util.*;

/**
 * @Classname 设置交集大小至少为2
 * @Date 2022/7/22 12:30 上午
 * @Created by sheen
 * @Description TODO
 */
public class 设置交集大小至少为2 {
    public static void main(String[] args) {
        设置交集大小至少为2 s = new 设置交集大小至少为2();
        System.out.println(s.intersectionSizeTwo(new int[][]{{1,3},{4,9},{0,10},{6,7},{1,2},{0,6},{7,9},{0,1},{2,5},{6,8}}));
    }
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        int i = 0;
        List<int[]> list = new ArrayList<>();
        while (i < intervals.length) {
            int index = i;
            int minIndex = i;
            while (index < intervals.length && intervals[i][0] == intervals[index][0]) {
                if(intervals[index][1] - intervals[index][0] < intervals[minIndex][1] - intervals[minIndex][0]) {
                    minIndex = index;
                }
                index ++;
            }
            list.add(intervals[minIndex]);
            i = index;
        }
        boolean flag = false;
        TreeSet<Integer> set = new TreeSet<>();
        int[] pre = new int[]{list.get(0)[0], list.get(0)[1]};
        i = 1;
        while (i < list.size()) {
            int[] item = list.get(i);
            if(pre[1] > item[0] && pre[0] <= item[0] && pre[1] <= item[1]){
                if(flag) {
                    set.add(pre[0]);
                    flag = false;
                }
                pre[0] = item[0];
            }else if(pre[0] < item[1] && pre[1] >= item[1] && pre[0] >= item[0]){
                pre[1] = item[1];
            }else if(pre[1] <= item[1] && pre[0] >= item[0]) {
                i++;
                continue;
            }else if(pre[1] >= item[1] && pre[0] <= item[0]) {
                if(flag) {
                    set.add(pre[0]);
                    flag = false;
                }
                pre = new int[]{item[0], item[1]};
            } else if(pre[1] == item[0]) {
                //set.add(pre[1]);
                if(flag) {
                    set.add(pre[0]);
                }
                if(set.contains(pre[1] - 1)) {
                    set.add(pre[1] + 1);
                }else {
                    set.add(pre[1] - 1);
                }
                flag = true;
                pre = new int[]{item[0], item[1]};
            }else if(pre[0] == item[1]) {
                set.add(pre[0] - 1);
                set.add(pre[0]);
            }else if(pre[1] < item[0]) {
                set.add(pre[1]);
                set.add(pre[1] - 1);
                pre = item;
            }else if(pre[0] > item[1]) {
                set.add(item[1]);
                set.add(item[1] - 1);
            }
            i++;
        }
        set.add(pre[0]);
        set.add(pre[0] + 1);
        return set.size();
    }
}
