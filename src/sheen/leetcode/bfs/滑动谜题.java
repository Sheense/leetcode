package sheen.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 滑动谜题 {

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        String source = "";
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                source += board[i][j];
            }
        }
        queue.offer(source);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size --!=0) {
                String str = queue.poll();
                if(set.contains(str)) continue;
                if(target.equals(str)) return res;
                set.add(str);

                int index = str.indexOf('0');
                if(index + 3 < 6) {
                    char[] c = str.toCharArray();
                    char swap = c[index];
                    c[index] = c[index + 3];
                    c[index+3] = swap;
                    queue.add(String.valueOf(c));
                }

                if(index != 0 && index != 3) {
                    char[] c = str.toCharArray();
                    char swap = c[index];
                    c[index] = c[index -1];
                    c[index-1] = swap;
                    queue.add(String.valueOf(c));
                }

                if(index != 2 && index != 5) {
                    char[] c = str.toCharArray();
                    char swap = c[index];
                    c[index] = c[index +1];
                    c[index+1] = swap;
                    System.out.println(String.valueOf(c));
                    queue.add(String.valueOf(c));
                }

                if(index - 3 > 0) {
                    char[] c = str.toCharArray();
                    char swap = c[index];
                    c[index] = c[index - 3];
                    c[index-3] = swap;
                    queue.add(String.valueOf(c));
                }
            }
            res ++;
        }
        return -1;
    }
}
