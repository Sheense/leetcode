package sheen.leetcode.array;

/**
 * @Classname 公交站间的距离
 * @Date 2022/7/24 12:17 上午
 * @Created by sheen
 * @Description TODO
 */
public class 公交站间的距离 {
    public static void main(String[] args) {
        公交站间的距离 s = new 公交站间的距离();
        System.out.println(s.distanceBetweenBusStops(new int[]{1,2,3,4}, 0, 3));
    }
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int res1 = 0;
        int i = start;
        while (i != destination) {
            res1 += distance[i];
            i++;
            i %= distance.length;
        }
        int res2 = 0;
        i = start;
        while (i !=  destination) {
            if(i == 0) {
                res2 += distance[distance.length - 1];
            }else {
                res2 += distance[i - 1];
            }
            i--;
            if(i < 0) {
                i += distance.length;
            }
        }
        return Math.min(res1, res2);
    }
}
