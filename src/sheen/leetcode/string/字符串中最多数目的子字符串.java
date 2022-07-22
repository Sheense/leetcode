package sheen.leetcode.string;

/**
 * @Classname 字符串中最多数目的子字符串
 * @Date 2022/3/19 11:04 下午
 * @Created by sheen
 * @Description TODO
 */
public class 字符串中最多数目的子字符串 {
    public static void main(String[] args) {
        字符串中最多数目的子字符串 s = new 字符串中最多数目的子字符串();
        System.out.println(s.maximumSubsequenceCount("fwymvreuftzgrcrxczjacqovduqaiig", "yy"));
    }
    public long maximumSubsequenceCount(String text, String pattern) {
        int arr[] = new int[text.length()];
        int a = 0;
        int b = 0;
        for(int i = text.length() - 1; i >= 0; i--) {
            if(text.charAt(i) == pattern.charAt(0)) {
                a++;
            }else if(text.charAt(i) == pattern.charAt(1)) {
                b++;
            }
            if(text.charAt(i) == pattern.charAt(1)) {
                if(i == text.length() - 1) {
                    arr[i] = 1;
                }else {
                    arr[i] = arr[i + 1] + 1;
                }
            }else {
                if(i != arr.length - 1) {
                    arr[i] = arr[i + 1];
                }
            }
        }

        long res = 0;
        for(int i = 0; i < text.length(); i ++) {
            if(text.charAt(i) == pattern.charAt(0)) {
                if(pattern.charAt(0) == text.charAt(i)) {
                    res += i + 1 < arr.length ? arr[i + 1] : 0;
                }else {
                    res += arr[i];
                }

            }
        }

        res += Math.max(a, b);
        return res;


    }
}
