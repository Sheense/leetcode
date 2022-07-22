package sheen.leetcode.math;

/**
 * @Classname 七进制数
 * @Date 2022/3/7 12:02 上午
 * @Created by sheen
 * @Description TODO
 */
public class 七进制数 {
    public String convertToBase7(int num) {
        boolean flag = false;
        if(num < 0 ){
            flag = true;
            num = 0 - num;
        }
        String res = "";
        while (num >= 7) {
            int yu = num % 7;
            num /= 7;
            res = yu + res;
        }
        res = num + res;
        return flag ? "-" + res : res;
    }
}
