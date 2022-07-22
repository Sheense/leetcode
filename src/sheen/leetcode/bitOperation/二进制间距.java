package sheen.leetcode.bitOperation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 二进制间距
 * @Date 2022/4/24 12:03 上午
 * @Created by sheen
 * @Description TODO
 */
public class 二进制间距 {
    public static void main(String[] args) {
        二进制间距 s = new 二进制间距();
        System.out.println(s.binaryGap(8));
    }
    public int binaryGap(int n) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (n != 0) {
            if((n & 1) == 1) {
                res.add(i);
            }
            i++;
            n >>= 1;
        }

        if(res.size() == 0) {
            return -1;
        }

        int ans = 0;
        for(int j = 0; j < res.size() - 1; j++) {
            ans = Math.max(ans, res.get(j + 1) - res.get(j));
        }
        return ans;
    }
}
