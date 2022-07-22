package sheen.leetcode.array;

public class 仅含1的子串数 {
    public static void main(String[] args) {
        仅含1的子串数 s = new 仅含1的子串数();
        System.out.println(s.numSub("111111"));
    }
    public int numSub(String s) {
        int res = 0;
        int index = -1;
        for(int i=0;i<s.length();i++) {
            if(index==-1&&s.charAt(i)=='1') {
                res+= 1;
                res%=1000000007;
                index=i;
            }else if(index!=-1&&s.charAt(i)=='1') {
                res+=(i-index+1);
                res%=1000000007;
            }else if(s.charAt(i)=='0') {
                index=-1;
            }
        }
        return res;
    }
}
