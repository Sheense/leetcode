package sheen.leetcode.binarySearch;

/**
 * @Classname 爱吃香蕉的珂珂
 * @Date 2022/6/7 12:05 上午
 * @Created by sheen
 * @Description TODO
 */
public class 爱吃香蕉的珂珂 {
    public static void main(String[] args) {
        爱吃香蕉的珂珂 s = new 爱吃香蕉的珂珂();
        System.out.println(s.minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;
        for (int i = 0; i<piles.length;i++){
            right = Math.max(piles[i], right);
        }

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(check(piles, h, mid)) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] piles, int h, int k) {
        int count = 0;
        for(int i = 0; i < piles.length; i++) {
            count += piles[i] / k;
            if(piles[i] % k != 0) {
                count++;
            }

            if(count > h) {
                return false;
            }
        }

        return true;
    }
}
