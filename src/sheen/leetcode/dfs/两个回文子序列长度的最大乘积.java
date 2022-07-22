package sheen.leetcode.dfs;

/**
 * @Classname 两个回文子序列长度的最大乘积
 * @Date 2021/9/12 2:41 下午
 * @Created by sheen
 * @Description TODO
 */
public class 两个回文子序列长度的最大乘积 {
    int max = 0;
    public int maxProduct(String s) {
        dfs(s, "", "", 0);
        return max;
    }

    public void dfs(String s, String a, String b, int index) {
        if(check(a) && check(b)) {
            max = Math.max(max, a.length() * b.length());
        }
        if(index >= s.length()) return;
        dfs(s, a + s.charAt(index), b, index+1);
        dfs(s, a, b + s.charAt(index), index+1);
        dfs(s, a, b, index+1);
    }

    public boolean check(String a) {
        int left = 0;
        int right = a.length() - 1;
        while (left <= right) {
            if(a.charAt(left) != a.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
