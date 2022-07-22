package sheen.leetcode.array;

/**
 * @Classname 提莫攻击
 * @Date 2021/11/10 1:51 上午
 * @Created by sheen
 * @Description TODO
 */
public class 提莫攻击 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        for(int i = 1; i < timeSeries.length; i++) {
            int time = timeSeries[i] - timeSeries[i-1];
            if(time >= duration) {
                res += duration;
            }else {
                res += time;
            }
        }
        res += duration;
        return res;
    }
}
