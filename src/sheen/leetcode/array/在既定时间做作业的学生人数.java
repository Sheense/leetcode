package sheen.leetcode.array;

/**
 * @Classname 在既定时间做作业的学生人数
 * @Date 2022/8/19 12:48 上午
 * @Created by sheen
 * @Description TODO
 */
public class 在既定时间做作业的学生人数 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for(int i = 0; i < startTime.length; i++) {
            if(queryTime >= startTime[i] && queryTime <= endTime[i]) {
                res++;
            }
        }
        return res;
    }
}
