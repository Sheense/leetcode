package sheen.leetcode.string;

/**
 * @Classname 隐藏个人信息
 * @Date 2023/4/1 8:59 下午
 * @Created by sheen
 * @Description TODO
 */
public class 隐藏个人信息 {
    public static void main(String[] args) {
        隐藏个人信息 s= new 隐藏个人信息();
        System.out.println(s.maskPII("(3906)2 07143 711"));
    }
    public String maskPII(String s) {
        if(s.contains("@")) {
            s = s.toLowerCase();
            int before = s.indexOf('@') - 1;
            return s.charAt(0) + "*****" + s.substring(before);
        }

        s = s.replace("+", "");
        s = s.replace("-", "");
        s = s.replace("(", "");
        s = s.replace(")", "");
        s = s.replace(" ", "");
        if(s.length() == 10) {
            return "***-***-" + s.substring(6);
        }
        if(s.length() == 11) {
            return "+*-***-***-" + s.substring(7);
        }

        if(s.length() == 12) {
            return "+**-***-***-" + s.substring(8);
        }
        if(s.length() == 13) {
            return "+**-***-***-" + s.substring(9);
        }
        return "";
    }
}
