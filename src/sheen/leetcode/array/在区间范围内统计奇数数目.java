package sheen.leetcode.array;

public class 在区间范围内统计奇数数目 {
    public int countOdds(int low, int high) {
        int num = high-low+1;
        if(num%2==0) {
            return num/2;
        }
        if(low%2==1) {
            return num/2+1;
        }
        return num/2;
    }
}
