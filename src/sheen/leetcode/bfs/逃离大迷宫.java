package sheen.leetcode.bfs;

import java.util.*;

/**
 * @Classname 逃离大迷宫
 * @Date 2022/1/11 12:22 上午
 * @Created by sheen
 * @Description TODO
 */
public class 逃离大迷宫 {
    public static void main(String[] args) {
        逃离大迷宫 s = new 逃离大迷宫();
        System.out.println(s.isEscapePossible(new int[][]
                {{0,1},{1,0}}, new int[]{0, 0}, new int[]{0,2}));
    }
    private int success = 1;
    private int block = -1;
    private int unknow = 0;
    private int len = (int)Math.pow(10, 6);
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if(blocked.length < 2) {
            return true;
        }
        Set<Long> blockSet = new HashSet<>();
        for(int i = 0; i < blocked.length; i++) {
            for(int j = 0; j < blocked[i].length; j++) {
                long v = blocked[i][0] * len + blocked[i][1];
                blockSet.add(v);
            }
        }
        long sourceV = source[0] * len + source[1];
        long targetV = target[0] * len + target[1];
        int res = bfs(sourceV, targetV, blockSet, blocked.length * (blocked.length - 1) / 2);
        if(res == success) {
            return true;
        }
        if(res == block) {
            return false;
        }
        res = bfs(targetV, sourceV, blockSet, blocked.length * (blocked.length - 1) / 2);
        return res != block;
    }

    private int bfs(long source, long target, Set<Long> blockSet, int count) {
        Queue<Long> queue = new LinkedList<>();
        queue.offer(source);
        Set<Long> set = new HashSet<>();
        set.add(source);
        while (!queue.isEmpty() && count > 0) {
            int size = queue.size();
            while (size-- != 0) {
                long num = queue.poll();
                long x = num / len;
                long y = num % len;
                if(num == target) {
                    return success;
                }

                long next = (x - 1) * len + y;
                if(x - 1 >= 0 && !set.contains(next) && !blockSet.contains(next)) {
                    count--;
                    queue.offer(next);
                    set.add(next);
                }

                next = (x + 1) * len + y;
                if(x + 1 < len && !set.contains(next) && !blockSet.contains(next)) {
                    count--;
                    queue.offer(next);
                    set.add(next);
                }

                next = x * len + y + 1;
                if(y + 1 < len && !set.contains(next) && !blockSet.contains(next)) {
                    count--;
                    queue.offer(next);
                    set.add(next);
                }

                next = x * len + y - 1;
                if(y - 1 >= 0 && !set.contains(next) && !blockSet.contains(next)) {
                    count--;
                    queue.offer(next);
                    set.add(next);
                }
            }
        }

        if(count > 0 ) {
            return block;
        }
        return unknow;
    }


}
