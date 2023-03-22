package sheen.leetcode.segmentArray;

/**
 * @Classname 拼车
 * @Date 2023/3/3 5:19 下午
 * @Created by sheen
 * @Description TODO
 */
public class 拼车 {
    public static void main(String[] args) {
        拼车 s = new 拼车();
        System.out.println(s.carPooling(new int[][]{{9,0,1},{3,3,7}}, 3
));
    }
    public boolean carPooling(int[][] trips, int capacity) {
        int[] time = new int[1001];
        for(int i = 0; i < trips.length; i++) {
            int count = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            time[from] += count;
            time[to] -= count;
        }

        if(time[0] > capacity) {
            return false;
        }
        for(int i = 1; i < time.length; i++) {
            time[i] += time[i - 1];
            if(time[i] > capacity) {
                return false;
            }
        }

        return true;
    }
}
