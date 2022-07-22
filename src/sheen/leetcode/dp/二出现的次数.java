package sheen.leetcode.dp;

public class 二出现的次数 {
    public static void main(String[] args) {
        二出现的次数 s = new 二出现的次数();
        System.out.println(s.numberOf2sInRange(1548));
    }

    int[] dp = new int[10];
    //dp[i] 表示Math.pow(10, i)有多少个2
    public int numberOf2sInRange(int n) {
        dp[1] = 1;
        for(int i=2;i<dp.length;i++) {
            //迭代推出到10的9次方的所有2
            dp[i] = dp[i-1] * 10 + (int)Math.pow(10, i-1);
        }
        return recall(n);
    }

    public int recall(int n) {
        if(n<=9){
            if(n>=2) return 1;
            else return 0;
        }
        //i代表n为几位数
        int i = 0;
        while (n / (int)Math.pow(10, i) != 0) {
            i++;
        }
        int res = 0;
        int s = n / (int)Math.pow(10, i-1);
        int yu = n % (int)Math.pow(10, i-1);
        res += s * dp[i-1];
        if(s>2) {
            res += (int)Math.pow(10, i-1);
        }else if(s == 2) {
            res += yu + 1; //从0开始，比如23，就有20，21，22，23
        }
        res += recall(yu);
        return res;
    }
}
