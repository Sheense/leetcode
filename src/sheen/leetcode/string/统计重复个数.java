package sheen.leetcode.string;

public class 统计重复个数 {

    public static void main(String[] args) {
        统计重复个数 s = new 统计重复个数();
        System.out.println(s.getMaxRepetitions("acb",4,"ab",2));
    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(n1==0) return 0;
        boolean [] check = new boolean[100];
        int [][] map = new int[100][2];
        int s1cnt = 0;
        int s2cnt = 0;
        int index = 0;
        int s1pre = 0;
        int s2pre = 0;
        int s1doop = 0;
        int s2doop = 0;
        while(true) {
            s1cnt++;
            for(int i=0;i<s1.length();i++) {
                if(s1.charAt(i)==s2.charAt(index)) {
                    index++;
                    if(index==s2.length()){
                        index = 0;
                        s2cnt++;
                    }
                }
            }
            if(s1cnt==n1) {
                return s2cnt/n2;
            }
            if(check[index]) {
                s1pre = map[index][0];
                s2pre = map[index][1];
                s1doop = s1cnt - map[index][0];
                s2doop = s2cnt - map[index][1];
                break;
            }else {
                check[index] = true;
                map[index][0] = s1cnt;
                map[index][1] = s2cnt;
            }
        }
        int all = s2pre +(n1-s1pre)/s1doop * s2doop;
        int yu = (n1-s1pre)%s1doop;
        for(int i=0;i<yu;i++){
            for(char ch : s1.toCharArray()) {
                if(ch == s2.charAt(index)) {
                    index++;
                    if(index==s2.length()) {
                        all += 1;
                        index=0;
                    }
                }
            }
        }
        return all/n2;
    }
}
