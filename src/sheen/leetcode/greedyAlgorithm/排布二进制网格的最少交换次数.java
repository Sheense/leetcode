package sheen.leetcode.greedyAlgorithm;

public class 排布二进制网格的最少交换次数 {

    public static void main(String[] args) {
        排布二进制网格的最少交换次数 s = new 排布二进制网格的最少交换次数();
        int[][] arr = {
                {0,1,1,0,0,0,0,0,0,0,0,0},
                {0,1,0,1,1,0,0,0,0,0,0,0},
                {0,1,1,1,0,0,0,0,0,0,0,0},
                {1,1,1,1,1,1,0,0,0,0,0,0},
                {1,1,1,1,0,1,1,0,0,0,0,0},
                {1,0,0,0,0,0,0,0,0,0,0,0},
                {1,0,1,1,1,1,0,0,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,0,0,0},
                {1,0,0,0,1,1,1,0,0,0,0,0},
                {0,0,1,1,1,0,1,0,0,0,0,0},
                {1,0,0,0,0,1,1,0,0,0,0,0},
                {0,1,0,0,0,0,0,0,0,0,0,0}
        };
        System.out.println(s.minSwaps(arr));
    }
    public int minSwaps(int[][] grid) {
        int[] arr = new int[grid.length];
        for(int i=0;i<grid.length;i++) {
            int num = 0;
            for(int j=grid.length-1;j>=0;j--) {
                if(grid[i][j]==0) {
                    num++;
                }else {
                    break;
                }
            }
            arr[i] = num;
        };
        int res = 0;
        for(int i=0;i<arr.length-1;i++) {
            int need = arr.length-1-i;
            int index = i;
            while(index<arr.length&&need > arr[index]) {
                index++;
            }
            if(index==grid.length) return -1;
            res += index-i;
            int value = arr[index];
            int j = index;
            while(j>i) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[i] = value;
        }
        return res;
    }
}
