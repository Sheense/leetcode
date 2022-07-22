package sheen.leetcode.math;

/**
 * @Classname Excel表列序号
 * @Date 2021/7/30 12:06 上午
 * @Created by sheen
 * @Description TODO
 */
public class Excel表列序号 {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for(int i = columnTitle.length() - 1; i >= 0; i--) {
            int w = columnTitle.length() - 1 - i;
            res += (int)Math.pow(26, w) * (columnTitle.charAt(i) - 'A' + 1);
        }
        return res;
    }
}
