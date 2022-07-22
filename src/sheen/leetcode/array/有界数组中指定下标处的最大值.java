package sheen.leetcode.array;

public class 有界数组中指定下标处的最大值 {
    public static void main(String[] args) {
        有界数组中指定下标处的最大值 s = new 有界数组中指定下标处的最大值();
        System.out.println(s.maxValue(4,2,6));
    }
    public int maxValue(int n, int index, int maxSum) {
        int height = 1;
        int has = n;
        int left = index;
        int right = index;
        while (has + (right - left + 1) <= maxSum&&(left!=0||right!=n-1)) {
            height++;
            has += right - left + 1;
            if(left > 0) left--;
            if(right < n-1) right++;
        }
        if(has>= maxSum) return height;
        return height + (maxSum - has) / n;
    }


}
