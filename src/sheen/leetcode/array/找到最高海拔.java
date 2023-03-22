package sheen.leetcode.array;

/**
 * @Classname 找到最高海拔
 * @Date 2022/11/19 1:56 上午
 * @Created by sheen
 * @Description TODO
 */
public class 找到最高海拔 {
    public int largestAltitude(int[] gain) {
        int start = 0;
        int res = 0;
        for(int i = 0; i < gain.length; i++) {
            start += gain[i];
            res = Math.max(res, start);
        }

        return res;
    }
}
