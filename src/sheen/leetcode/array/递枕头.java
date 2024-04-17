package sheen.leetcode.array;

/**
 * @Classname 递枕头
 * @Date 2023/9/26 00:14
 * @Created by sheen
 * @Description TODO
 */
public class 递枕头 {
    public int passThePillow(int n, int time) {
        int res = 1;
        boolean flag = false;
        for(int i = 1; i <= time; i++) {
            if(!flag) {
                res++;
                if(res == n) {
                    flag = true;
                }
            }else {
                res --;
                if(res == 1) {
                    flag = false;
                }
            }
        }
        return res;
    }
}
