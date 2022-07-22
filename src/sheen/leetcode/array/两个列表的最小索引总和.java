package sheen.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * @Classname 两个列表的最小索引总和
 * @Date 2022/3/14 12:29 上午
 * @Created by sheen
 * @Description TODO
 */
public class 两个列表的最小索引总和 {
    public static void main(String[] args) {
        两个列表的最小索引总和 s = new 两个列表的最小索引总和();
        System.out.println(s.findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
       new String[] {"KFC","Burger King","Tapioca Express","Shogun"}));
    }
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        for(int i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }
        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for(Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            if(map2.containsKey(key)) {
                if(min > map1.get(key) + map2.get(key)) {
                    min = map1.get(key) + map2.get(key);
                    res = new ArrayList<>();
                    res.add(key);
                }else if(min == map1.get(key) + map2.get(key)) {
                    res.add(key);
                }
            }
        }
        String[] ans = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
