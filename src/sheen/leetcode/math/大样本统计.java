package sheen.leetcode.math;

import sheen.leetcode.util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 大样本统计
 * @Date 2023/5/27 2:04 下午
 * @Created by sheen
 * @Description TODO
 */
public class 大样本统计 {
    public static void main(String[] args) {
        大样本统计 s = new 大样本统计();
        ArrayUtils.print(s.sampleStats(new int[]{0,1,3,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
    }
    public double[] sampleStats(int[] count) {
        List<Integer> v = new ArrayList<>();
        List<Long> vCount = new ArrayList<>();
        int min = -1;
        int max = -1;
        int maxCount = 0;
        int maxV = 0;

        double all = 0;
        long allCount = 0;
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                if(min == -1) {
                    min = i;
                }
                max = Math.max(max, i);
                if(maxCount < count[i]) {
                    maxCount = count[i];
                    maxV = i;
                }
                allCount += count[i];
                all += (long)count[i] * i;

                v.add(i);
                if(!vCount.isEmpty()) {
                    vCount.add(count[i] + vCount.get(vCount.size() - 1));
                }else {
                    vCount.add((long) count[i]);
                }
            }
        }
        double median = 0;
        if(allCount % 2 == 1) {
            long target = allCount / 2 + 1;
            for(int i = 0; i < vCount.size(); i++) {
                if(target <= vCount.get(i)) {
                    median = v.get(i);
                    break;
                }
            }
        }else {
            long left = allCount / 2;
            long right = allCount / 2 + 1;
            for(int i = 0; i < vCount.size(); i++) {
                if(left < vCount.get(i) && right <= vCount.get(i)) {
                    median = v.get(i);
                    break;
                }else if(left == vCount.get(i)) {
                    median = (double)(v.get(i) + v.get(i + 1)) / 2;
                    break;
                }
            }
        }

        double mean = all / allCount;


        return new double[]{min, max, mean, median, maxV};
    }
}
