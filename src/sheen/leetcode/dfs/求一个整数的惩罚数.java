package sheen.leetcode.dfs;

/**
 * @Classname 求一个整数的惩罚数
 * @Date 2023/10/25 00:06
 * @Created by sheen
 * @Description TODO
 */
public class 求一个整数的惩罚数 {
    public int punishmentNumber(int n) {
        int res = 0;
        for(int i = 1; i <= n; i++) {
            int v = i * i;
            if(isTarget(i, String.valueOf(v), 0, 0)) {
                res += v;
            }
        }
        return res;
    }

    public boolean isTarget(int i, String vStr, int index, int v) {
        if(index == vStr.length()) {
            return v == i;
        }

        if(vStr.charAt(index) == '0') {
            return isTarget(i, vStr, index + 1, v);
        }else {
            for(int j = index; j < vStr.length(); j++) {
                int next = Integer.parseInt(vStr.substring(index, j + 1));
                boolean flag = isTarget(i, vStr, j + 1, next + v);
                if(flag) {
                    return true;
                }
            }
        }
        return false;
    }
}
