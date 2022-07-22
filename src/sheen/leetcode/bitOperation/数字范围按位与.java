package sheen.leetcode.bitOperation;

public class 数字范围按位与 {
    public static void main(String[] args) {
        数字范围按位与 s = new 数字范围按位与();
        System.out.println(s.rangeBitwiseAnd(0,0));
    }
    public int rangeBitwiseAnd(int m, int n) {
        int time = 0;
        long value = (long)Math.pow(2, time);
        while(value<=n) {
            time++;
            value = (long)Math.pow(2, time);
        }
        if(time==0) return 0;
        time--;
        int res = (int)Math.pow(2, time);
        if(res>m) return 0;
        return res + rangeBitwiseAnd(m-res, n-res);
    }
}
