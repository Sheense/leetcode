package sheen.leetcode.greedyAlgorithm;

public class 翻转矩阵后的得分 {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int res = 0;
        for(int i= 0;i<n;i++) {
            if(i==0) res += (1<<(n-1))*m;
            else {
                int k = 0;
                for(int j=0;j<m;j++) {
                    if(A[j][0]==0) {
                        k+=(A[j][i]==0?1:0);
                    }else {
                        k+=(A[j][i]==1?1:0);
                    }
                }
                if(k>=m-k) {
                    res += k*((1<<(n-1-i)));
                }else {
                    res += (m-k)*((1<<(n-1-i)));
                }
            }
        }
        return res;
    }
}
