package sheen.leetcode.binarySearch;

public class 有效的完全平方数 {

    public static void main(String[] args) {
        有效的完全平方数 s = new 有效的完全平方数();
        System.out.println(s.isPerfectSquare(16));
    }
    public boolean isPerfectSquare(int num) {
        long start = 0;
        long end = num;
        while(start<=end) {
            long mid = (start+end)/2;
            if(mid*mid==num) {
                return true;
            }else if(mid*mid>num) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}
