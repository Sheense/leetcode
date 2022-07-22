package sheen.leetcode.string;

public class 整理字符串 {
    public static void main(String[] args) {
        整理字符串 s = new 整理字符串();
        System.out.println(s.makeGood("jeSsEJ"));
    }
    public String makeGood(String s) {
        boolean flag = true;
        while(flag) {
            flag = false;
            int i = 0;
            String newString  ="";
            while(i<s.length()) {
                if(i==s.length()-1) {
                    newString+=s.charAt(i);
                    break;
                }
                if(s.charAt(i)>='A'&&s.charAt(i)<='Z') {
                    if(s.charAt(i+1)-'a'!=s.charAt(i)-'A') {
                        newString += s.charAt(i);
                        i++;
                    }else {
                        i+=2;
                        flag = true;
                    }
                }else {
                    if(s.charAt(i+1)-'A'!=s.charAt(i)-'a') {
                        newString += s.charAt(i);
                        i++;
                    }else {
                        i+=2;
                        flag = true;
                    }
                }
            }
            s = newString;
        }
        return s;
    }
}
