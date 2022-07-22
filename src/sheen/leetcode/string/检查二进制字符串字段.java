package sheen.leetcode.string;

public class 检查二进制字符串字段 {
    public boolean checkOnesSegment(String s) {
        int i =0;
        while(i<s.length()&&s.charAt(i)=='1') {
            i++;
        }
        while (i<s.length()) {
            if(s.charAt(i)=='1') return false;
            i++;
        }
        return true;
    }
}
