package sheen.leetcode.recall;

public class Pow50 {
    public static void main(String[] args) {
        Pow50 s = new Pow50();
        System.out.println(s.myPow(34.00515, -3));
    }

    public double myPow(double x, int n) {
        if(n==0) return 1;
        return recall(x, n);
    }

    public double recall(double x, int n) {
        if(n==-1) {
            return 1/x;
        }
        if(n==1) {
            return x;
        }
        int m = n/2;
        int yushu = n%2;
        double num = recall(x, m);
        if(yushu==1||yushu==-1) {
            if(n<0) x = 1/x;
            return num * num * x;
        }
        return num*num;
    }
}
