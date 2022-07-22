package sheen.leetcode.binarySearch;

public class 有序矩阵中第K小的元素 {

    public static void main(String[] args) {
        有序矩阵中第K小的元素 s = new 有序矩阵中第K小的元素();
        int [][] matrix = {
                            {1,1,3,8,13},
                            {4,4,4,8,18},
                            {9,14,18,19,20},
                            {14,19,23,25,25},
                            {18,21,26,28,29}

        };
        System.out.println(s.kthSmallest(matrix, 13));
    }
    public int kthSmallest(int[][] matrix, int k) {
        if(k==1) return matrix[0][0];
        int left = matrix[0][0];
        int right = matrix[matrix.length-1][matrix[0].length-1];
        int mid = left;
        while(left<right) {
            mid = (left+right)/2;
            int n = mid_k(matrix, mid,k);
            if(n>k) {
                right = mid;
            }else if(n<k){
                left = mid+1;
            }else break;
        }
        return right;
    }

    public int mid_k(int[][] matrix, int mid,int target) {
        int count = 0;
        int j = matrix[0].length-1;
        for(int i=0;i<matrix.length;i++) {
            while(j>=0&&matrix[i][j]>mid) {
                j--;
            }
            count += j+1;
        }
        return count;
    }
}


