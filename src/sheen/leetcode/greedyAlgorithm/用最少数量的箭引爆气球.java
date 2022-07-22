package sheen.leetcode.greedyAlgorithm;

public class 用最少数量的箭引爆气球 {
    public static void main(String[] args) {
        用最少数量的箭引爆气球 s = new 用最少数量的箭引爆气球();
        System.out.println(s.findMinArrowShots(new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},
                {2,9},{0,9},{3,9},{0,6},{2,8}}));
    }
    public int findMinArrowShots(int[][] points) {
        if(points.length==0) return 0;
        sort(0, points.length-1, points,0);
        int start = 0;
        while(start<points.length){
            int end = start;
            while(end+1<points.length&&points[end+1][0] == points[start][0]) end++;
            sort(start, end, points,1);
            start = end+1;
        }
        int res = 0;
        int index = 0;
        while(index<points.length) {
            int right = points[index][1];
            int left = points[index][0];
            while(index+1<points.length&&points[index+1][0]<=right&&points[index+1][0]>=left) {
                index++;
                left = points[index][0];
                right = Math.min(right, points[index][1]);
            }
            res++;
            index++;
        }
        return res;
    }

    public void sort(int start, int end, int[][] points, int sortIndex) {
        if(start>=end) return ;
        int left = start;
        int right = end;
        int[] m = points[left];
        while(left<right) {
            while(left<right&&m[sortIndex]<=points[right][sortIndex]) right--;
            points[left] = points[right];
            while (left<right&&m[sortIndex]>=points[left][sortIndex]) left++;
            points[right] = points[left];
        }
        points[left] = m;
        sort(start, left-1, points,sortIndex);
        sort(left+1, end, points,sortIndex);
    }
}
