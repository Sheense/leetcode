package sheen.leetcode.string;

/**
 * @Classname 将字符串拆分为若干长度为k的组
 * @Date 2022/1/16 10:36 上午
 * @Created by sheen
 * @Description TODO
 */
public class 将字符串拆分为若干长度为k的组 {
    public String[] divideString(String s, int k, char fill) {
        int size = s.length() % k == 0 ? s.length() / k : (s.length() / k + 1);
        String[] res = new String[size];
        int start = 0;
        for(int i = 0; i < size; i++) {
            if(i == size - 1) {
                res[i] = s.substring(start, Math.min(start + k, s.length()));
                while (res[i].length() < k) {
                    res[i] += fill;
                }
            }else {
                res[i] = s.substring(start, start + k);
            }
            start = start + k;
        }
        return res;
    }
}
