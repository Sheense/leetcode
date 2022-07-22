package sheen.leetcode.dp;

public class 俄罗斯套娃信封问题 {
    public static void main(String[] args) {
        俄罗斯套娃信封问题 s = new 俄罗斯套娃信封问题();
        System.out.println(s.maxEnvelopes(new int[][]{{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}}));
    }
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length==0) return 0;
        sort(envelopes, 0, envelopes.length-1);
        int res = 1;
        int dp[] = new int[envelopes.length];
        for(int i=0;i<dp.length;i++) {
            int target = envelopes[i][0] - 1 + envelopes[i][1] - 1;
            int left = 0;
            int right = i - 1;
            while(left <= right) {
                int mid = (left + right) / 2;
                if(envelopes[mid][0] + envelopes[mid][1]<=target) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            int max = 0;
            for(int j = right;j>=0;j--) {
                if(envelopes[j][0]<envelopes[i][0]&&envelopes[j][1]<envelopes[i][1]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = 1 + max;
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public void sort(int [][] envelopes, int start, int end) {
        if(start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int[] m = envelopes[start];
        while(left<right) {
            while (left<right&&compareTo(m, envelopes[right])<=0) right--;
            envelopes[left] = envelopes[right];
            while (left<right&&compareTo(m, envelopes[left])>=0) left++;
            envelopes[right] = envelopes[left];
        }
        envelopes[left] = m;
        sort(envelopes, start, left - 1);
        sort(envelopes, left+1, end);
    }

    public int compareTo(int[] a, int [] b) {
        int i = a[0] + a[1];
        int j = b[0] + b[1];
        if(i>j) return 1;
        else if(i<j) return -1;
        return 0;
    }
}
