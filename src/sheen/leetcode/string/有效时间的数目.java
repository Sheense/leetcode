package sheen.leetcode.string;

/**
 * @Classname 有效时间的数目
 * @Date 2023/5/9 12:02 上午
 * @Created by sheen
 * @Description TODO
 */
public class 有效时间的数目 {
    public int countTime(String time) {
        int res = 1;
        String[] times = time.split(":");
        if(times[0].charAt(0) == '?') {
            if(times[0].charAt(1) == '?') {
                res = 24;
            }else {
                if(times[0].charAt(1) >= '4') {
                    res = 2;
                }else {
                    res = 3;
                }
            }
        }else {
            if(times[0].charAt(1) == '?') {
                if(times[0].charAt(0) <= '1') {
                    res = 10;
                }else {
                    res = 4;
                }
            }
        }

        if(times[1].charAt(0) == '?') {
            if(times[1].charAt(1) == '?') {
                res *= 60;
            }else {
                res *= 6;
            }
        }else {
            if(times[1].charAt(1) == '?') {
                res *= 10;
            }
        }
        return res;
    }
}
