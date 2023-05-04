package sheen.algorithm.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname shein
 * @Date 2023/3/27 7:58 下午
 * @Created by sheen
 * @Description TODO
 */
public class shein {
    private static final String dataPath = "s3://mildom-recommend/lgs/dc/app_data/300/rawlog/video/";

    public static void main(String[] args) {
        System.out.println(getTarget(new int[]{7,8,9,1,2,3,4,5,6}, 2));
        System.out.println(getPath("20230327"));
    }
    public static List<String> getPath(String date) {
        String year = date.substring(0, 4);
        String month = date.substring(4, 6);
        String day = date.substring(6);
        List<String> res = new ArrayList<>();
        for (int i = 0; i <= 23; i++) {
            String hour = String.valueOf(i);
            if (i < 10) {
                hour = "0" + hour;
            }
            res.add(dataPath + year + "/" + month + "/" + day + "/" + hour);
        }

        return res;
    }

    public static int getTarget(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(arr[left] > arr[right]) {
                if(arr[mid] > target) {
                    if(arr[mid] >= arr[left]) {
                        if(arr[right] >= target) {
                            left = mid + 1;
                        }else {
                            right = mid - 1;
                        }
                    }else {
                        right = mid - 1;
                    }
                }else if(arr[mid] < target) {
                    if(arr[mid] >= arr[left]) {
                        left = mid + 1;
                    }else {
                        if(arr[right] >= target) {
                            left = mid + 1;
                        }else {
                            right = mid - 1;
                        }
                    }
                }else {
                    return mid;
                }
            }else {
                if(arr[mid] >= target) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
        }
        int res = (left == arr.length || arr[left] != target ? -1 : left);
        return res;
    }
}
