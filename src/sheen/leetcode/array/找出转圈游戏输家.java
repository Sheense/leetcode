package sheen.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 找出转圈游戏输家
 * @Date 2023/8/16 00:15
 * @Created by sheen
 * @Description TODO
 */
public class 找出转圈游戏输家 {
    public int[] circularGameLosers(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int now = 0;
        int i = 1;
        while(!set.contains(now)) {
            set.add(now);
            now += k * i;
            now %= n;
            i++;
        }

        int len = n - set.size();
        if(len == 0) {
            return new int[]{};
        }
        int[] res = new int[len];
        int z = 0;
        for(int j = 1; j <= n; j++) {
            if(!set.contains(j - 1)) {
                res[z++] = j;
            }
        }
        return res;
    }
}
