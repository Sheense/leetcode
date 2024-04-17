package sheen.leetcode.array;

/**
 * @Classname 将钱分给最多的儿童
 * @Date 2023/9/22 00:22
 * @Created by sheen
 * @Description TODO
 */
public class 将钱分给最多的儿童 {
    public int distMoney(int money, int children) {
        if(children * 8 < money) {
            return children - 1;
        }

        if((money == 4 && children == 1) || (money < children)) {
            return -1;
        }

        int res = 0;
        for(int i = 1; i <= children; i++) {
            int yu = money - i * 8;
            if(yu > 0) {
                int yuNum = children - i;
                if(yuNum == 1 && yu == 4) {
                    continue;
                }

                if(yuNum > yu) {
                    continue;
                }
                res = i;
            }else if(yu == 0) {
                if(children == i) {
                    res = children;
                }
            }
        }

        return res == 0 ? -1 : res;
    }


}
