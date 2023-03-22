package sheen.leetcode.map;

import java.util.HashSet;
import java.util.Set;

/**
 * @Classname 破解保险箱
 * @Date 2023/1/10 5:13 下午
 * @Created by sheen
 * @Description TODO
 */
public class 破解保险箱 {

    private Set<Integer> set = new HashSet<>();
    private int k = 0;
    private int n = 0;
    private int mod;
    private String res = "";
    public String crackSafe(int n, int k) {
        this.k = k;
        this.mod = (int)Math.pow(10, n - 1);
        this.n = n;
        dfs(0);
        for(int i = 1; i < n; i++) {
            res += "0";
        }

        return res;
    }

    public void dfs(int v) {
        for(int i = 0; i < k; i++) {
            int edge = v * 10 + i;
            if(!set.contains(edge)) {
                set.add(edge);
                dfs(edge % mod);
                res += i;
            }
        }
    }
}
