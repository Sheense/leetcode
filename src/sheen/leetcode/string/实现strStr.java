package sheen.leetcode.string;

public class 实现strStr {

    public static void main(String[] args) {
        实现strStr s = new 实现strStr();
        System.out.println(s.strStr("mississippi","issipi"));
    }
    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        if(haystack.equals(needle)) return 0;
        if(needle.equals("")) return 0;
        if(haystack.equals("")) return -1;
        int[] next = next(needle);
        int i = 0;
        int j = 0;
        while(i<haystack.length()) {
            if(haystack.charAt(i)!=needle.charAt(j)) {
                i++;
            }else {
                while(j<needle.length()&&i<haystack.length()&&haystack.charAt(i)==needle.charAt(j)) {
                    i++;
                    j++;
                }
                if(j==needle.length()) {
                    return i-needle.length();
                }
                if(i==haystack.length()) return -1;
                do {
                    j = next[j];
                }while (j!=-1&&haystack.charAt(i)!=needle.charAt(j));
                j++;
                i++;
            }
        }
        return -1;
    }

    //Kmp算法：arr[j]!=arr[i]时。next[j] 表示下一个与i比较的下标
    //求next数组要回溯，
    public int[] next(String s) {
        int[] next = new int[s.length ()];
        next[0] = -1;
        int i = 0;
        int j = -1;
        while(i<s.length()-1) {
            if(j==-1||s.charAt(j)==s.charAt(i)) {
                i++;
                j++;
                next[i]=j;
            }else {
                j = next[j];
            }
        }
        return next;
    }
}
