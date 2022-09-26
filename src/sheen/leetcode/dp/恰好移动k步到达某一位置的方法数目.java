package sheen.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 恰好移动k步到达某一位置的方法数目
 * @Date 2022/9/4 4:28 下午
 * @Created by sheen
 * @Description TODO
 */
public class 恰好移动k步到达某一位置的方法数目 {
    public static void main(String[] args) {
        恰好移动k步到达某一位置的方法数目 s = new 恰好移动k步到达某一位置的方法数目();
        System.out.println(s.numberOfWays(272, 270, 6));
    }
    public int numberOfWays(int startPos, int endPos, int k) {

        int add = (k - Math.abs(startPos - endPos)) / 2;
        int start;
        int end;
        if(startPos > endPos) {
            end = startPos + add;
            start = endPos - add;
        }else {
            start = startPos - add;
            end = endPos + add;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int mod = (int)Math.pow(10, 9) + 7;
        map.put(startPos , 1);
        for(int i = 1; i < k + 1; i++) {
            Map<Integer, Integer> tmp = new HashMap<>();
            for(int j = start; j <= end; j++) {
                int v = (map.getOrDefault(j - 1, 0) + map.getOrDefault(j + 1, 0)) % mod;
                tmp.put(j, v);
            }
            map = tmp;
        }
        return map.getOrDefault(endPos, 0);
    }
}
