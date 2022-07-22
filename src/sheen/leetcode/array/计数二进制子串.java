package sheen.leetcode.array;

public class 计数二进制子串 {
    public static void main(String[] args) {
        计数二进制子串 s = new 计数二进制子串();
        System.out.println(s.countBinarySubstrings("10101"));
    }
    public int countBinarySubstrings(String s) {
        int i =0;
        char c1 = s.charAt(0);
        int time1=0;
        while(i<s.length()&&s.charAt(i)==c1) {
            i++;
            time1++;
        }
        int res = 0;
        while(i<s.length()) {
            int time2= 0;
            char c2 = s.charAt(i);
            while(i<s.length()&&s.charAt(i)==c2) {
                time2++;
                i++;
            }
            res += Math.min(time1,time2);
            time1 = time2;
            c1 = c2;
        }
        return res;
    }
}
