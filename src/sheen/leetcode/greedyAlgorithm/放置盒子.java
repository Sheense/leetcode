package sheen.leetcode.greedyAlgorithm;

/**
 * @Classname 放置盒子
 * @Date 2022/12/25 10:50 上午
 * @Created by sheen
 * @Description TODO
 */
public class 放置盒子 {
    public static void main(String[] args) {
        放置盒子 s = new 放置盒子();
        System.out.println(s.minimumBoxes(15));
    }
    public int minimumBoxes(int n) {
        int left = 1;
        int right = Math.min(n, 100000);
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(can(mid, n)) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        int res =  getFloor(left - 1);
        n -= getAll(left - 1);
        right = left;
        left = 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int floor = getFloor(mid);
            if(floor >= n) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return res + left;
    }
    public boolean can(int mid, int count) {
        return getAll(mid) >= count;
    }

    public long getAll(int mid) {
        long res = 0;
        for(int i = mid; i >= 1; i--) {
            res += getFloor(i);
        }

        return res;
    }

    public int getFloor(int mid) {
        return mid * (mid + 1) / 2;
    }
}
