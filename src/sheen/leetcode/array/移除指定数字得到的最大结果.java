package sheen.leetcode.array;

/**
 * @Classname 移除指定数字得到的最大结果
 * @Date 2022/5/1 10:34 上午
 * @Created by sheen
 * @Description TODO
 */
public class 移除指定数字得到的最大结果 {
    public String removeDigit(String number, char digit) {
        String res = "";
        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == digit) {
                String value;
                if(i == 0) {
                    value = number.substring(1);
                }else if(i == number.length() - 1) {
                    value = number.substring(0, number.length() - 1);
                }else {
                    value = number.substring(0, i) + number.substring(i + 1);
                }
                if(res.equals("")) {
                    res = value;
                }else {
                    res = big(res, value);
                }
            }
        }
        return res;
    }

    public String big(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > b.charAt(i)) {
                return a;
            } else if (a.charAt(i) < b.charAt(i)) {
                return b;
            }
        }
        return a;
    }
}
