package sheen.leetcode.window;

public class 字符串的排列 {
    public static void main(String[] args) {
        字符串的排列 s = new 字符串的排列();
        System.out.println(s.checkInclusion("ab","eidbaooo"));
    }
    public boolean checkInclusion(String s1, String s2) {
        int [] arr1 = new int[26];
        int [] arr2 = new int[26];
        int k = 0;
        while(k<=s2.length()-s1.length()){
            if(k==0){
                for(int i=0;i<s1.length();i++) {
                    arr1[s1.charAt(i)-'a']++;
                    arr2[s2.charAt(i)-'a']++;
                }
            }else {
                arr2[s2.charAt(k-1)-'a']--;
                arr2[s2.charAt(s1.length()-1+k)-'a']++;
            }
            if(check(arr1, arr2)) return true;
            k++;
        }
        return false;
    }

    public boolean check(int[] arr1, int [] arr2) {
        for(int i=0;i<arr1.length;i++) {
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
}
