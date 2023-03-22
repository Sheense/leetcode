package sheen.leetcode.array;

/**
 * @Classname 统计同构子字符串的数目
 * @Date 2022/12/26 12:11 上午
 * @Created by sheen
 * @Description TODO
 */
public class 统计同构子字符串的数目 {
    public int countHomogenous(String s) {
        int mod = (int)Math.pow(10, 9) + 7;
        long res = 0;
        int i = 0;
        while (i < s.length()) {
            int index = i;
            while (i < s.length() && s.charAt(index) == s.charAt(i)) {
                i++;
            }
            res += (long)(i - index) * (i - index + 1) / 2;
            res %= mod;
        }

        return (int)res;
    }
}
