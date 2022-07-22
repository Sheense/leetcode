package sheen.leetcode.greedyAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 煎饼排序
 * @Date 2022/2/19 1:57 上午
 * @Created by sheen
 * @Description TODO
 */
public class 煎饼排序 {
    public static void main(String[] args) {
        煎饼排序 s = new 煎饼排序();
        System.out.println(s.pancakeSort(new int[]{3,2,4,1}));
    }
    public List<Integer> pancakeSort(int[] arr) {
        int index = arr.length;
        while (index > 0 && arr[index - 1] == index) {
            index--;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= index; i++) {
            map.put(arr[i - 1], i);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = index; i > 0; i--) {
            int p = map.get(i);
            if(p == i) {
                continue;
            }
            if(p != 1) {
                res.add(p);
                for(int j = 0; j < p / 2; j++) {
                    int a = map.get(arr[j]);
                    int b = map.get(arr[p - 1 - j]);
                    map.put(arr[j], b);
                    map.put(arr[p - 1 - j], a);
                    int temp = arr[j];
                    arr[j] = arr[p - 1 - j];
                    arr[p - 1 - j] = temp;
                }
            }

            res.add(i);
            for(int j = 0; j < i / 2; j++) {
                int a = map.get(arr[j]);
                int b = map.get(arr[i - 1 - j]);
                map.put(arr[j], b);
                map.put(arr[i - 1 - j], a);

                int temp = arr[j];
                arr[j] = arr[i - 1 - j];
                arr[i - 1 - j] = temp;
            }
        }
        return res;
    }
}
