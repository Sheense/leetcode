package sheen.leetcode.array;

/**
 * @Classname 旋转数字
 * @Date 2022/9/25 4:18 下午
 * @Created by sheen
 * @Description TODO
 */
public class 旋转数字 {
    public int rotatedDigits(int n) {
        int res = 0 ;
        for(int i = 1; i <= n; i++) {
            int num = i;
            int newNum = 0;
            int m = 1;
            boolean flag = true;
            while (num != 0) {
                int q = num % 10;
                int t = transform(q);
                if(t == -1) {
                    flag = false;
                    break;
                }
                newNum += t * m;
                m *= 10;
                num /= 10;
            }

            if(flag) {
                if(newNum!=i) {
                    res++;
                }
            }
        }
        return res;
    }

    public int transform(int n) {
        switch (n) {
            case 0: return 0;
            case 1: return 1;
            case 8: return 8;
            case 2: return 5;
            case 5: return 2;
            case 6: return 9;
            case 9: return 6;
            default:return -1;
        }
    }
}
