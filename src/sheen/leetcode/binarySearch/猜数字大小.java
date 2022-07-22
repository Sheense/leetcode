package sheen.leetcode.binarySearch;

public class 猜数字大小 {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = ( right - left) /2 + left;
            if(guess(mid) > 0) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }

    public int guess(int n) {
        return -1;
    }
}
