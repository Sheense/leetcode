package sheen.leetcode.binarySearch;

/**
 * @Classname 阶乘函数后K个零
 * @Date 2022/8/28 2:15 下午
 * @Created by sheen
 * @Description TODO
 */
public class 阶乘函数后K个零 {
    public static void main(String[] args) {
        阶乘函数后K个零 s = new 阶乘函数后K个零();
        System.out.println(s.preimageSizeFZF(1000000000));
    }
    public int preimageSizeFZF(int k) {
        return (int)(search(k + 1) - search(k));
    }

    public long search(int k) {
        long left = 0;
        long right = 5L * k;
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            if(zeta(mid) >= k) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public long zeta(long x) {
        long res = 0;
        while (x != 0) {
            x/=5;
            res += x / 5;
        }
        return res;
    }
}
