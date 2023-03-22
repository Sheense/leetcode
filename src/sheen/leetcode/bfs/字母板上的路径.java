package sheen.leetcode.bfs;

/**
 * @Classname 字母板上的路径
 * @Date 2023/2/12 1:34 上午
 * @Created by sheen
 * @Description TODO
 */
public class 字母板上的路径 {
    public static void main(String[] args) {
        字母板上的路径 s = new 字母板上的路径();
        System.out.println(s.alphabetBoardPath("leet"));
    }
    public String alphabetBoardPath(String target) {
        String res = "";
        char now = 'a';
        for(int i = 0; i < target.length(); i++) {
            if(target.charAt(i) == now) {
                res += "!";
                continue;
            }
            int[] start = getPoint(now);
            int[] end;
            if(target.charAt(i) == 'z') {
                end = getPoint('u');
            }else {
                end = getPoint(target.charAt(i));
            }
            if(start[0] != end[0]) {
                if(start[0] < end[0]) {
                    for(int j = 0; j < end[0] - start[0]; j++) {
                        res+= "D";
                    }
                }else {
                    for(int j = 0; j < start[0] - end[0]; j++) {
                        res+= "U";
                    }
                }
            }

            if(start[1] != end[1]) {
                if(start[1] < end[1]) {
                    for(int j = 0; j < end[1] - start[1]; j++) {
                        res+= "R";
                    }
                }else {
                    for(int j = 0; j < start[1] - end[1]; j++) {
                        res+= "L";
                    }
                }
            }
            if(target.charAt(i) == 'z') {
                res += "D";
            }
            res += "!";


            now = target.charAt(i);
        }

        return res;
    }

    public int[] getPoint(char c) {
        int v = c - 'a';
        return new int[]{v / 5, v % 5};
    }
}
