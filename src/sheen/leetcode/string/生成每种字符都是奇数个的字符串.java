package sheen.leetcode.string;

/**
 * @Classname 生成每种字符都是奇数个的字符串
 * @Date 2022/8/1 12:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 生成每种字符都是奇数个的字符串 {
    public static void main(String[] args) {
        生成每种字符都是奇数个的字符串 s = new 生成每种字符都是奇数个的字符串();
        System.out.println(s.generateTheString(2));
    }
    public String generateTheString(int n) {
        if(n == 1) {
            return "a";
        }
        String res = "";
        if (n % 2 == 0) {
            int mid = n / 2;
            if(mid % 2 == 0) {
                for(int i = 0; i < mid - 1; i++) {
                    res += 'a';
                }
                for(int j = 0; j < mid + 1; j++) {
                    res += 'b';
                }
            }else {
                for(int i = 0; i < mid; i++) {
                    res += "ab";
                }
            }
        }else {
            int mid = n / 2;
            if(mid % 2 == 0) {
                for(int i = 0; i < mid + 1; i++) {
                    res += 'a';
                }
                for(int j = 0; j < mid - 1; j++) {
                    res += 'b';
                }
                res += 'c';
            }else {
                for(int i = 0; i < mid; i++) {
                    res += "ab";
                }
                res += 'c';
            }
        }
        return res;
    }
}
