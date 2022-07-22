package sheen.leetcode.array;

public class 使数组中所有元素相等的最小操作数 {
    public int minOperations(int n) {
        int res = 0;
        int time = n/2;
        for(int i=1;i<=time;i++) {
            if(n%2==1) {
                res += 2*i;
            }else {
                res += (2*i-1);
            }
        }
        return res;
    }
}
