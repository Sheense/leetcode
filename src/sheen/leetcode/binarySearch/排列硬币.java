package sheen.leetcode.binarySearch;

/**
 * @Classname 排列硬币
 * @Date 2021/10/10 2:01 下午
 * @Created by sheen
 * @Description TODO
 */
public class 排列硬币 {
    public static void main(String[] args) {
        排列硬币 s = new 排列硬币();
        System.out.println(s.arrangeCoins(5));
    }
    public int arrangeCoins(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            long mid = ((long)right + left) / 2;
            long count = mid*(mid + 1) / 2;
            if(count > n) {
               right = (int)mid - 1;
            }else {
                left = (int)mid + 1;
            }
        }
        return right;
    }
}
