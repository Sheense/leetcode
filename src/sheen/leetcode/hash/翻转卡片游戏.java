package sheen.leetcode.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Classname 翻转卡片游戏
 * @Date 2023/8/2 00:04
 * @Created by sheen
 * @Description TODO
 */
public class 翻转卡片游戏 {

    public static void main(String[] args) {
        翻转卡片游戏 s = new 翻转卡片游戏();
        //System.out.println(s.flipgame(new int[]{1,2,4,4,7}, new int[]{1,3,4,1,3}));
        //System.out.println(s.flipgame(new int[]{1}, new int[]{1}));
        System.out.println(s.flipgame(new int[]{1,3,2,1,1,4,4,2,4,3}, new int[]{1,2,4,4,3,2,3,2,3,3}));
    }
    public int flipgame(int[] fronts, int[] backs) {
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < fronts.length; i++) {
            if(fronts[i] != backs[i]) {
                boolean r1 = true;
                boolean r2 = true;
                for(int j = 0; j < fronts.length; j++) {
                    if(i != j ) {
                        if(fronts[j] == fronts[i] && backs[j] == fronts[i]) {
                            r1 = false;
                        }
                        if(fronts[j] == backs[i] && backs[j] == backs[i]) {
                            r2 = false;
                        }
                    }
                    if(!r1 && !r2) {
                        break;
                    }
                }
                if(r1) {
                    res = Math.min(fronts[i], res);
                }

                if(r2) {
                    res = Math.min(backs[i], res);
                }
            }
        }
        if(res == Integer.MAX_VALUE) {
            return 0;
        }
        return res;
    }

    public boolean check(Map<Integer, Set<Integer>>  hash, int key, int index) {
        if(!hash.containsKey(key)) {
            return true;
        }

        if(hash.get(key).size() > 1) {
            return false;
        }

        return hash.get(key).contains(index);
    }
}
