package sheen.leetcode.recall;

/**
 * @Classname 最多可达成的换楼请求数目
 * @Date 2022/2/28 1:15 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最多可达成的换楼请求数目 {

    public int maximumRequests(int n, int[][] requests) {
        int[] arr = new int[n];
        return recall(0, 0, requests, arr, 0);
    }

    public int recall(int max, int index, int[][] requests, int[] arr, int cnt) {
        if(check(arr)) {
            max = Math.max(cnt, max);
        }
        if(index >= requests.length) {
            return max;
        }

        arr[requests[index][0]]--;
        arr[requests[index][1]]++;
        int a = recall(max, index + 1, requests, arr, cnt + 1);
        arr[requests[index][0]]++;
        arr[requests[index][1]]--;
        max = Math.max(a, max);
        int b = recall(max, index + 1, requests, arr, cnt);
        max = Math.max(b, max);
        return max;
    }

    public boolean check(int[] arr ) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
