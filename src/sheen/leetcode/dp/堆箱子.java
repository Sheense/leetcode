package sheen.leetcode.dp;


public class 堆箱子 {
    public static void main(String[] args) {
        堆箱子 s = new 堆箱子();
        System.out.println(s.pileBox(new int[][] {{1, 1, 1}, {2, 3, 4}, {2, 6, 7}, {3, 4, 5}}));
    }
    public int pileBox(int[][] box) {
        int dp[] = new int[box.length];
        sort(box, 0, box.length-1);
        int res = 0;
        for(int i=0;i<box.length;i++) {
            dp[i] = box[i][2];
            int max = 0;
            for(int j=i-1;j>=0;j--) {
                if(box[j][0]<box[i][0]&&box[j][1]<box[i][1]&&box[j][2]<box[i][2]&&dp[j]>max) {
                    max = dp[j];
                }
            }
            dp[i] += max;
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public void sort(int [][] box, int start , int end) {
        if(start>end)return;
        int left = start- 1;
        int right = end + 1;
        int mid = box[start][2];
        int index = start;
        while (index<right) {
            if(box[index][2] == mid) {
                index++;
            }else if(box[index][2] < mid) {
                left++;
                int[] item = box[index];
                box[index] = box[left];
                box[left] = item;
            }else {
                right--;
                int[] item = box[index];
                box[index] = box[right];
                box[right] = item;
            }
        }
        sort(box, start, left);
        sort(box, right, end);
    }
}
