package sheen.leetcode.bitOperation;

/**
 * @Classname 最大二进制奇数
 * @Date 2024/3/13 00:15
 * @Created by sheen
 * @Description TODO
 */
public class 最大二进制奇数 {
    public String maximumOddBinaryNumber(String s) {
        int oneCount = 0;
        int zeroCount = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                zeroCount++;
            }else {
                oneCount++;
            }
        }

        String res = "";
        for(int i = 0; i < oneCount - 1; i++) {
            res += "1";
        }

        for (int i = 0; i < zeroCount; i++) {
            res += "0";
        }

        return res + "1";
    }

}
