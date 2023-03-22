package sheen.leetcode.array;

/**
 * @Classname 数组中字符串的最大值
 * @Date 2022/12/10 11:07 下午
 * @Created by sheen
 * @Description TODO
 */
public class 数组中字符串的最大值 {
    public int maximumValue(String[] strs) {
        int res = 0;
        for(int i = 0; i < strs.length; i++) {
            int v = 0;
            for(int j = 0; j < strs[i].length(); j++) {
                if(strs[i].charAt(j) >= '0' && strs[i].charAt(j) <= '9') {
                    v = v * 10 + (strs[i].charAt(j) - '0');
                }else {
                    v = strs[i].length();
                    break;
                }
            }
            res = Math.max(v, res);
        }
        return res;
    }
}
