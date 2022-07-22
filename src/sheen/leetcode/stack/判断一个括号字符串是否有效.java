package sheen.leetcode.stack;

/**
 * @Classname 判断一个括号字符串是否有效
 * @Date 2021/12/25 11:11 下午
 * @Created by sheen
 * @Description TODO
 */
public class 判断一个括号字符串是否有效 {
    public static void main(String[] args) {
        判断一个括号字符串是否有效 s = new 判断一个括号字符串是否有效();
        System.out.println(s.canBeValid("())()))()(()(((())(()()))))((((()())(())", "1011101100010001001011000000110010100101"));
        //System.out.println(s.canBeValid("(())","0101"));
    }
    public boolean canBeValid(String s, String locked) {
        if(s.length() % 2 == 1) return false;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(locked.charAt(i) == '0' || (s.charAt(i) == '(' && locked.charAt(i) == '1')) {
                count++;
            }else {
                count--;
                if(count < 0) {
                    return false;
                }
            }
        }
        if(count % 2 == 1) return false;
        count = 0;
        for(int i = s.length() - 1; i >= 0; i -- ){
            if(locked.charAt(i) == '0' || (s.charAt(i) == ')' && locked.charAt(i) == '1')) {
                count++;
            }else {
                count --;
                if(count < 0){
                    return false;
                }
            }
        }
        return true;
    }
}
