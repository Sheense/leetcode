package sheen.leetcode.array;

public class 单调数列 {
    public boolean isMonotonic(int[] A) {
        if(A.length==0||A.length==1||A.length==2) return true;
        boolean isFu = false;
        int i =1;
        while(i<A.length&&A[i]==A[i-1]) i++;
        if(i == A.length) return true;
        isFu = A[i] - A[i-1] < 0;
        for(;i<A.length;i++) {
            if(A[i]-A[i-1]!=0) {
                boolean flag = A[i] - A[i-1] < 0;
                if(flag!=isFu) return false;
            }
        }
        return true;
    }
}
