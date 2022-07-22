package sheen.leetcode.array;

public class 比特位计数 {
    public int[] countBits(int num) {
        int [] res = new int[num+1];
        int v = 0;
        for(int i=0;i<res.length;i++) {
            if(i==0||i==1) {
                res[i] = i;
            }else {
                if(Math.pow(2, v+1)==i) {
                    v++;
                    res[i] = 1;
                }else {
                   res[i] = 1 + res[i - (int)Math.pow(2, v)];
                }
            }
        }
        return res;
    }
}
