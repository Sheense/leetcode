package sheen.leetcode.greedyAlgorithm;

import java.util.PriorityQueue;

/**
 * @Classname 强密码检验器
 * @Date 2022/4/2 12:23 上午
 * @Created by sheen
 * @Description TODO
 */
public class 强密码检验器 {
    public static void main(String[] args) {
        强密码检验器 s = new 强密码检验器();
        System.out.println("ABABABABABABABABABAB1".length());
    }
    public int strongPasswordChecker(String password) {
        int n = password.length();
        int big = 0;
        int small = 0;
        int num = 0;
        for(int i = 0; i < password.length(); i++) {
            if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                small = 1;
            }else if(password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                big = 1;
            }else if(password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                num = 1;
            }
        }
        int type = big + small + num;

        if(n < 6) {
            return Math.max(6 - n, 3 - type);
        }else if(n >= 6 && n <= 20){
            int i = 0;
            int cnt = 0;
            while (i < password.length()) {
                int index = i;
                while (index < password.length() && password.charAt(index) == password.charAt(i)) {
                    index++;
                }
                int count = index - i;
                cnt += count / 3;
                i = index;
            }
            return Math.max(cnt, 3 - type);
        }else {
            PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> x[0] - y[0]);
            int i = 0;
            int cnt = 0;
            while (i < password.length()) {
                int index = i;
                while (index < password.length() && password.charAt(index) == password.charAt(i)) {
                    index++;
                }
                int count = index - i;
                cnt += count / 3;
                if(count >= 3) {
                    queue.add(new int[]{count % 3, count});
                }
                i = index;
            }
            int delete = n - 20;
            while (!queue.isEmpty()) {
                int[] peek = queue.poll();
                if(peek[0] == 0) {
                    if(delete < 1) {
                        break;
                    }
                    delete--;
                    cnt--;
                    peek[0] = 2;
                    peek[1]--;
                    if(peek[1] >= 3) {
                        queue.add(peek);
                    }
                }else if(peek[0] == 1) {
                    if(delete < 2) {
                        break;
                    }
                    delete-= 2;
                    cnt--;
                    peek[0] = 2;
                    peek[1]-= 2;
                    if(peek[1] >= 3) {
                        queue.add(peek);
                    }
                }else if(peek[0] == 2) {
                    if(delete < 3) {
                        break;
                    }
                    delete-= 3;
                    cnt--;
                    peek[0] = 2;
                    peek[1]-= 3;
                    if(peek[1] >= 3) {
                        queue.add(peek);
                    }
                }
            }
            return (n - 20 ) + Math.max(cnt, 3 - type);
        }

    }
}
