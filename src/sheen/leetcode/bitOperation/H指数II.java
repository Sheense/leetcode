package sheen.leetcode.bitOperation;

public class H指数II {
    public static void main(String[] args) {
        H指数II s = new H指数II();
        System.out.println(s.hIndex(new int[]{0,1,3,5,6}));
    }
    public int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(citations[mid] >= citations.length - mid) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return citations.length - left;
    }
}
