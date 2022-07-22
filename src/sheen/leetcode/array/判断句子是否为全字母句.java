package sheen.leetcode.array;

public class 判断句子是否为全字母句 {
    public boolean checkIfPangram(String sentence) {
        boolean[] bool = new boolean[26];
        for(int i=0;i<sentence.length();i++) {
            bool[sentence.charAt(i) - 'a'] = true;
        }
        for(int i=0;i<bool.length;i++) {
            if(!bool[i]) return false;
        }
        return true;
    }
}
