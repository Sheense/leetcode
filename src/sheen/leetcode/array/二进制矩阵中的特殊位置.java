package sheen.leetcode.array;

public class 二进制矩阵中的特殊位置 {
    public int numSpecial(int[][] mat) {
        int res = 0;
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[i].length;j++) {
                if(mat[i][j]==1) {
                    boolean flag = true;
                    for(int z=0;z<mat.length;z++) {
                        if(mat[z][j]==1&&z!=i) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        for(int z = 0;z<mat[i].length;z++) {
                            if(mat[i][z]==1&&z!=j) {
                                flag = false;
                                break;
                            }
                        }
                        if(flag) res++;
                    }
                }
            }
        }
        return res;
    }

}
