package sheen.leetcode.dp;

public class 最长重复子数组 {

    public static void main(String[] args) {
        最长重复子数组 s = new 最长重复子数组();
        System.out.println(s.findLength(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7}));
    }

    public int findLength(int[] A, int[] B) {
        int[][] map = new int[B.length][A.length];
        int max = 0;
        for(int i=0;i<B.length;i++) {
            for(int j=0;j<A.length;j++) {
                if(i==0) {
                    if(A[j]==B[i]) {
                        map[i][j] = 1;
                    }
                }else {
                    if(A[j]==B[i]) {
                        if(j!=0) {
                            map[i][j] = map[i-1][j-1] + 1;
                        }else {
                            map[i][j] = 1;
                        }
                    }
                }
                if(max<map[i][j]) max = map[i][j];
            }
        }
        return max;
    }
}
