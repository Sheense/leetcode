package sheen.leetcode.binarySearch;

/**
 * @Classname 乘法表中第k小的数
 * @Date 2022/5/18 12:35 上午
 * @Created by sheen
 * @Description TODO
 */
public class 乘法表中第k小的数 {
    public static void main(String[] args) {
        乘法表中第k小的数 s = new 乘法表中第k小的数();
        System.out.println(s.findKthNumber(1, 3, 2));
    }
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = mid / n * n;
            for(int i = mid/n + 1; i <= m; i++) {
                count += mid / i;
            }
            if(count < k) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
