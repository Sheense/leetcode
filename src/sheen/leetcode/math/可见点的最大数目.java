package sheen.leetcode.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * @Classname 可见点的最大数目
 * @Date 2021/12/16 12:51 上午
 * @Created by sheen
 * @Description TODO
 */
public class 可见点的最大数目 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int sameAnt = 0;
        List<Double> list = new ArrayList<>();
        int lx = location.get(0);
        int ly = location.get(1);
        for(int i = 0 ; i < points.size(); i++) {
            int px = points.get(i).get(0);
            int py = points.get(i).get(1);
            if(px == lx && py == ly) {
                sameAnt++;
                continue;
            }
            Double value = Math.atan2(py - ly, px - lx);
            list.add(value);
        }
        Collections.sort(list);
        int m = list.size();
        for(int i = 0; i < m; i++) {
            list.add(list.get(i) + 2 * Math.PI);
        }

        int max = 0;
        Double toDegree = angle * Math.PI / 180;
        for(int i = 0; i < list.size(); i++) {
            max = Math.max(max, search(list, i, list.get(i) + toDegree) - i);
        }
        return max + sameAnt;
    }

    public int search(List<Double> list, int index, double target) {
        int left = index;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(list.get(mid) > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
