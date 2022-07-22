package sheen.leetcode.game;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 我能赢吗
 * @Date 2022/5/22 12:45 上午
 * @Created by sheen
 * @Description TODO
 */
public class 我能赢吗 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        Map<Long, Boolean> map = new HashMap<>();
        int all = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if(all < desiredTotal) {
            return false;
        }

        return dfs(0L, map, desiredTotal, 0, maxChoosableInteger);
    }

    public boolean dfs(long use, Map<Long, Boolean> map, int desiredTotal, int num, int max) {
        if(!map.containsKey(use)) {
            boolean res = false;
            for(int i = 0; i < max; i++) {
                if((use & (1L << i)) == 0) {
                    if(i + 1 + num >= desiredTotal) {
                        res = true;
                        break;
                    }

                    if(!dfs((use | (1L << i)), map, desiredTotal, num + i + 1, max)) {
                        res = true;
                        break;
                    }
                }
            }
            map.put(use, res);
        }
        return map.get(use);
    }
}
