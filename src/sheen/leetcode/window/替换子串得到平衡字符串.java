package sheen.leetcode.window;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 替换子串得到平衡字符串
 * @Date 2023/2/13 12:16 上午
 * @Created by sheen
 * @Description TODO
 */
public class 替换子串得到平衡字符串 {
    public static void main(String[] args) {
        替换子串得到平衡字符串 s = new 替换子串得到平衡字符串();
        System.out.println(s.balancedString("QQQW"));
    }
    public int balancedString(String s) {
        int[] arr = new int[4];
        for(int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'Q' : arr[0] ++; break;
                case 'W' : arr[1] ++; break;
                case 'E' : arr[2] ++; break;
                case 'R' : arr[3] ++; break;
            }
        }
        int mid = s.length() / 4;
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > mid) {
                list.add(new int[]{i, arr[i] - mid});
            }
        }
        if(list.isEmpty()) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int[] now = new int[4];
        int res = Integer.MAX_VALUE;
        while (right < s.length()) {
            while (right < s.length() && !isOK(now, list)) {
                switch (s.charAt(right)) {
                    case 'Q' : now[0] ++; break;
                    case 'W' : now[1] ++; break;
                    case 'E' : now[2] ++; break;
                    case 'R' : now[3] ++; break;
                }
                right++;
            }

            while (left < right && isOK(now, list)) {
                switch (s.charAt(left)) {
                    case 'Q' : now[0] --; break;
                    case 'W' : now[1] --; break;
                    case 'E' : now[2] --; break;
                    case 'R' : now[3] --; break;
                }
                left++;
            }

            res = Math.min(res, right - left + 1);
        }

        return res;
    }

    public boolean isOK(int[] now, List<int[]> list) {
        for(int[] item : list) {
            if(now[item[0]] < item[1]) {
                return false;
            }
        }

        return true;
    }
}
