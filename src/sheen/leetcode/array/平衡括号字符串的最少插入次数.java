package sheen.leetcode.array;

public class 平衡括号字符串的最少插入次数 {
    public static void main(String[] args) {
        平衡括号字符串的最少插入次数 s = new 平衡括号字符串的最少插入次数();
        System.out.println(s.minInsertions("(()))(()))()())))"));
    }
    public int minInsertions(String s) {
        int right = 0;
        int need = 0;
        int res = 0;
        int i = s.length()-1;
        while(i>=0){
            if(s.charAt(i)=='(') {
                if(right > 0) {
                    right--;
                }else if(need>0){
                    res++;
                    need--;
                }else {
                    res+=2;
                }
            }else {
                i--;
                if(i>=0&&s.charAt(i)==')') {
                    right++;
                }else if(i>=0&&s.charAt(i)=='(') {
                    if(right > 0) {
                        right--;
                        need++;
                    }else {
                        res+=1;
                    }
                }else {
                    need++;
                }
            }
            i--;
        }
        if(need>0){
            res += need*2;
        }
        if(right>0) {
            res += right;
        }

        return res;
    }
}
