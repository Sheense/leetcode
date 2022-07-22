package sheen.leetcode.binarySearch;

public class x的平方根 {

    public static void main(String[] args) {
        x的平方根 s = new x的平方根();
        System.out.println(s.mySqrt(2147395599));
    }

    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        while(start<=end) {
            long mid = (start+end)/2;
            if(mid*mid==(long)x) {
                return (int)mid;
            } else if(mid*mid>x){
                if((mid-1)*(mid-1)<(long)x) {
                    return (int)mid-1;
                } else {
                    end = mid-1;
                }
            }else {
                start = mid+1;
            }
        }
        return 0;
    }
}
