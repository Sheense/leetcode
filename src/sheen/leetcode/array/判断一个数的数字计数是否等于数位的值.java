package sheen.leetcode.array;

/**
 * @Classname 判断一个数的数字计数是否等于数位的值
 * @Date 2022/5/28 10:31 下午
 * @Created by sheen
 * @Description TODO
 */
public class 判断一个数的数字计数是否等于数位的值 {
    public boolean digitCount(String num) {
        int[] arr = new int[11];
        for(int i = 0; i < num.length(); i++) {
            arr[num.charAt(i) - '0'] ++;
        }

        for(int i = 0; i < num.length(); i++) {
            int count = num.charAt(i) - '0';
            if(count != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
