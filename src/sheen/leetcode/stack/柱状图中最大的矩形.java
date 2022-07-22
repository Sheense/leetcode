package sheen.leetcode.stack;

/*
单调栈
 */
public class 柱状图中最大的矩形 {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0) return 0;
        int max =0;
        for(int i=0;i<heights.length;i++) {
            int left = i;
            int right = i;
            boolean flag1 = true;
            boolean flag2 = true;
            while(flag1||flag2) {
                if(left-1>=0&&heights[left-1]>=heights[i]) {
                    left--;
                }else {
                    flag1 = false;
                }
                if(right+1<heights.length&&heights[right+1]>=heights[i]) {
                    right++;
                }else {
                    flag2 = false;
                }
            }
            max = max>heights[i]*(right-left+1)?max:heights[i]*(right-left+1);
        }
        return max;
    }
}
