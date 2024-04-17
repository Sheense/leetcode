package sheen.leetcode.math;

/**
 * @Classname 计算列车到站时间
 * @Date 2023/9/8 00:01
 * @Created by sheen
 * @Description TODO
 */
public class 计算列车到站时间 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
