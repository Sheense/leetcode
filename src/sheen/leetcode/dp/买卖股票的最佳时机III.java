package sheen.leetcode.dp;

public class 买卖股票的最佳时机III {

    public static void main(String[] args) {
        买卖股票的最佳时机III s = new 买卖股票的最佳时机III();
        System.out.print(s.maxProfit(new int[] {3,2,6,5,0,3}));
    }

    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int [] startMax = new int[prices.length];
        int [] endMax = new int[prices.length];
        int min = prices[0];
        for(int i=0;i<prices.length;i++) {
            startMax[i] = prices[i]-min;
            if(prices[i]<min) min = prices[i];
        }
        int max = prices[prices.length-1];
        int maxFee = 0;
        for(int i=prices.length-1;i>=0;i--) {
            endMax[i] = max - prices[i]<maxFee ? maxFee : max - prices[i];
            maxFee = endMax[i] < maxFee? maxFee : endMax[i] ;
            if(max<prices[i]) max = prices[i];
        }
        int res = 0;
        for(int i=0;i<prices.length;i++) {
            if(i+1<prices.length){
                int temp = startMax[i] + endMax[i+1];
                res = res<temp ? temp : res;
            } else {
                res = res<startMax[i] ? startMax[i] : res;
            }
        }
        return res;
    }
}
