package sheen.leetcode.bitOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 得到新鲜甜甜圈的最多组数
 * @Date 2023/1/22 3:44 下午
 * @Created by sheen
 * @Description TODO
 */
public class 得到新鲜甜甜圈的最多组数 {
    private static final int BIT = 5;
    private static final int BATCH = (1 << 5) - 1;

    public static void main(String[] args) {
        得到新鲜甜甜圈的最多组数 s = new 得到新鲜甜甜圈的最多组数();

        System.out.println(s.maxHappyGroups(9, new int[]{298148512,266520299,406786559,804851972,600623393,4304578,203837753,567325621,471128999,621785239,22585811,33080261,673801543,650287622,260102349,896931288,279598926,221841310,185598694,305781935,159354503,582332530,215228600,293373862}));
    }
    public int maxHappyGroups(int batchSize, int[] groups) {
        int[] count = new int[batchSize];
        for(int i = 0; i < groups.length; i++) {
            count[groups[i] % batchSize] ++;
        }
        long mask = 0;
        for(int i = 1; i < count.length; i++) {
            mask = ((long)count[i] << ((i - 1) * BIT)) | mask;
        }

        return dfs(new HashMap<>(), mask, batchSize) + count[0];
    }

    public int dfs(Map<Long, Integer> map, long mask, int batchSize) {
        if(mask == 0) {
            return 0;
        }

        if(map.containsKey(mask)) {
            return map.get(mask);
        }

        long total = 0;
        for(int i = 1; i < batchSize; i++) {
            total += i * ((mask >> ((i - 1) * BIT)) & BATCH);
        }

        int best = 0;
        for(int i = 1; i < batchSize; i++) {
            long count = (mask >> ((i - 1) * BIT)) & BATCH;
            if(count > 0) {
                int result = dfs(map, mask - (1L << ((i - 1) * BIT)) , batchSize);
                if(total % batchSize == i) {
                    result ++;
                }
                best = Math.max(best, result);
            }
        }

        map.put(mask, best);
        return best;
    }
}
