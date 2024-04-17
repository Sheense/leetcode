package sheen.leetcode.string;

/**
 * @Classname 赎金信
 * @Date 2024/1/7 04:07
 * @Created by sheen
 * @Description TODO
 */
public class 赎金信 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] c1 = new int[26];
        int[] c2= new int[26];
        for(int i = 0; i < ransomNote.length(); i++) c1[ransomNote.charAt(i) - 'a']++;
        for(int i = 0; i < magazine.length(); i++) c2[magazine.charAt(i) - 'a']++;
        for(int i = 0; i < c1.length; i++) {
            if(c1[i] != 0 && c1[i] > c2[i]) {
                return false;
            }
        }
        return true;

    }
}
