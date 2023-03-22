package sheen.leetcode.window;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 水果成篮
 * @Date 2022/10/17 12:32 上午
 * @Created by sheen
 * @Description TODO
 */
public class 水果成篮 {
    public static void main(String[] args) {
        水果成篮 s = new 水果成篮();
        System.out.println(s.totalFruit(new int[]{0,1,2}));
    }
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < fruits.length) {
            while (right < fruits.length && map.size() <= 2) {
                if(!map.containsKey(fruits[right]) && map.size() + 1 > 2) {
                    break;
                }
                map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
                right++;
            }

            res = Math.max(res, right - left);
            while (map.size() > 1) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
        }
        return res;
    }
}
