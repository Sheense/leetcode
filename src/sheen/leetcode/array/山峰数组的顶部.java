package sheen.leetcode.array;

/**
 * @Classname 山峰数组的顶部
 * @Date 2021/10/14 12:12 上午
 * @Created by sheen
 * @Description TODO
 */
public class 山峰数组的顶部 {
    public int peakIndexInMountainArray(int[] arr) {
        if(arr.length == 1) return 0;
        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                if(arr[i] > arr[i - 1]) {
                    return i;
                }
            }else if(i == arr.length - 1) {
                if(arr[i-1] < arr[i]) {
                    return i;
                }
            }else if(arr[i] > arr[i-1] && arr[i+1] < arr[i]) {
                return i;
            }
        }
        return 0;
    }
}
