package sheen.leetcode.array;

public class 加一 {

    public int[] plusOne(int[] digits) {
        int j = 0;
        digits[digits.length-1] = digits[digits.length-1] +1;
        for(int i=digits.length-1;i>=0;i--) {
            if(digits[i]+j>=10) {
                digits[i] = (digits[i]+j)%10;
                j = 1;
            }else {
                digits[i] = digits[i]+j;
                j=0;
                break;
            }
        }
        if(j==0) {
            return digits;
        }else {
            int[] res = new int[digits.length+1];
            for(int i=0;i<res.length;i++) {
                if(i==0) {
                    res[i] = j;
                }else {
                    res[i] = digits[i-1];
                }
            }
            return res;
        }
    }
}
