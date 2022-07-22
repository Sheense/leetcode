package sheen.leetcode.array;

public class 分割字符串的方案数 {

    public static void main(String[] args) {
        分割字符串的方案数 s = new 分割字符串的方案数();
        System.out.println(s.numWays("00000000"));
    }

    public int numWays(String s) {
        int num = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='1') num++;
        }
        if(num==0){
            int res = 0;
            int start = s.length()-2;
            for(int i=0;i<s.length()-2;i++) {
                res += start;
                res%=1000000007;
                start--;
            }
            return res;
        }
        if(num%3!=0) return 0;
        int value = num/3;
        int a = 0;
        int b = 0;
        int all = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='1') {
                all++;
            }
            if(all==value) {
                a++;
            }
            if(all==value*2) {
                b++;
            }
        }
        return (int)(((long)a*b)%1000000007);
    }
}
