package sheen.leetcode.string;

public class 删除字符串中的所有相邻重复项 {
    public static void main(String[] args) {
        删除字符串中的所有相邻重复项 s = new 删除字符串中的所有相邻重复项();
        System.out.println(s.removeDuplicates("abbaca"));
    }
    public String removeDuplicates(String S) {
        String res = S;
        boolean flag = true;
        while(flag) {
            flag = false;
            String item = "";
            int index = 0;
            while(index<res.length()) {
                if(index+1<res.length()&&res.charAt(index) == res.charAt(index+1)) {
                    index+=2;
                    flag = true;
                }else {
                    item += res.charAt(index);
                    index++;
                }
            }
            res = item;
        }
        return res;
    }
}
