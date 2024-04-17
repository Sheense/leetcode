package sheen.leetcode.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @Classname 到家的最少跳跃次数
 * @Date 2023/8/30 00:12
 * @Created by sheen
 * @Description TODO
 */
public class 到家的最少跳跃次数 {
    public static void main(String[] args) {
        到家的最少跳跃次数 s = new 到家的最少跳跃次数();
        System.out.println(s.minimumJumps(new int[]{14,4,18,1,15}, 3, 15, 9));
        System.out.println(s.minimumJumps(new int[]{8,3,16,6,12,20}, 15, 13, 11));
        System.out.println(s.minimumJumps(new int[]{1,6,2,14,5,17,4}, 16, 9, 7));
        System.out.println(s.minimumJumps(new int[]{128,178,147,165,63,11,150,20,158,144,136}, 61, 170, 135));
    }
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if(x == 0) {
            return 0;
        }
        Set<Long> set = new HashSet<>();
        Set<Integer> forbiddenSet = new HashSet<>();
        List<int[]> list = new ArrayList<>();
        int max = 0;
        list.add(new int[]{0, 0});
        for(int i = 0; i < forbidden.length; i++) {
            forbiddenSet.add(forbidden[i]);
            max = Math.max(max, forbidden[i]);
        }
        int bound = Math.max(max + a, x) + b;
        set.add(0L);
        return bfs(list, set, a, b, x, 0, forbiddenSet, bound);
    }

    public int bfs(List<int[]> list, Set<Long> set, int a, int b, int x, int count, Set<Integer> forbidden, int bound) {
        if(list.isEmpty()) {
            return -1;
        }
        count++;
        List<int[]> next = new ArrayList<>();
        for(int[] item : list) {
            int now = item[0];
            int afterCount = item[1];
            int[] nextPoint1 = new int[]{now + a, 0};
            long v1 = getValue(nextPoint1);
            if(!forbidden.contains(now + a) && !set.contains(v1) && now + a <= bound) {
                if(now + a == x) {
                    return count;
                }
                next.add(nextPoint1);
                set.add(v1);
            }

            int[] nextPoint2 = new int[]{now - b, afterCount + 1};
            long v2 = getValue(nextPoint2);
            if(afterCount < 1 && now - b >= 0 && !forbidden.contains(now - b) && !set.contains(v2)) {
                if(now - b == x) {
                    return count;
                }
                next.add(nextPoint2);
                set.add(v2);
            }
        }
        return bfs(next, set, a, b, x, count, forbidden,bound);
    }

    public long getValue(int[] item) {
        return item[1] * 10000000000000L + item[0];
    }


    public boolean isValid(int x, int now, int a, int b) {
        return (x + 2 * b - now) % a == 0;
    }

}
