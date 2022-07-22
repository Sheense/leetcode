package sheen.leetcode.math;

/**
 * @Classname 从英文中重建数字
 * @Date 2021/11/24 12:14 上午
 * @Created by sheen
 * @Description TODO
 */
public class 从英文中重建数字 {
    public static void main(String[] args) {
        从英文中重建数字 s = new 从英文中重建数字();
        System.out.println(s.originalDigits("zeroonetwothreefourfivesixseveneightnine"));
    }
    public String originalDigits(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }

        int [] res = new int[10];
        if(arr['z' - 'a'] != 0) {
            res[0] = arr['z' - 'a'];
        }
        if(arr['w' - 'a'] != 0) {
            res[2] = arr['w' - 'a'];
        }

        if(arr['u' - 'a'] != 0) {
            res[4] = arr['u' - 'a'];
        }

        if(arr['x' - 'a'] != 0) {
            res[6] = arr['x' - 'a'];
        }

        if(arr['g' - 'a'] != 0) {
            res[8] = arr['g' - 'a'];
        }

        res[5] = arr['f' - 'a'] - res[4];
        res[3] = arr['h' - 'a'] - res[8];
        res[7] = arr['s' - 'a'] - res[6];
        res[9] = arr['i' - 'a'] - res[5] - res[6] - res[8];

        res[1] = arr['o' - 'a'] - res[0] - res[2] - res[4];

        String ans = "";
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res[i]; j++) {
                ans += i;
            }
        }
        return ans;
    }
}
