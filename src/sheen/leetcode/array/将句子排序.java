package sheen.leetcode.array;

public class 将句子排序 {
    public String sortSentence(String s) {
        String[] str = s.split(" ");
        String[] res = new String[str.length];
        for(int i=0;i<str.length;i++) {
            int index = Integer.valueOf(str[i].substring(str[i].length() - 1)) - 1;
            String v = str[i].substring(0, str[i].length() - 1);
            res[index] = v;
        }
        String ans = "";
        for(int i=0;i<res.length;i++) {
            ans += res[i];
            if(i!=res.length-1) {
                ans += " ";
            }
        }
        return ans;
    }
}
