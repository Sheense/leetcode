package sheen.leetcode.test;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(process(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int process(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            sum += arr[i];
            max = Math.max(sum, max);
            if(sum<0) {
                sum = 0;
            }
        }
        return max;
    }
}
