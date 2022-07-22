package sheen.leetcode.recall;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 整数替换
 * @Date 2021/11/19 12:42 上午
 * @Created by sheen
 * @Description TODO
 */
public class 整数替换 {
    public static void main(String[] args) {
        整数替换 s = new 整数替换();
        System.out.println(s.integerReplacement(Integer.MAX_VALUE));
    }
    public int integerReplacement(int n) {
        return recall(new HashMap<>(), n);
    }

    public int recall(Map<Long, Integer> map, long n) {
        if(n == 1) {
            return 0;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }

        int v;
        if(n % 2 == 0) {
            v = recall(map, n / 2) + 1;
        }else {
            v = Math.min(recall(map, n - 1), recall(map, n + 1)) + 1;
        }
        map.put(n, v);
        return v;
    }
}
