package sheen.leetcode.array;

import java.util.Arrays;

public class 旋转盒子 {
    public char[][] rotateTheBox(char[][] box) {
        char[][] res = new char[box[0].length][box.length];
        for(int i= 0;i<res.length;i++) {
            Arrays.fill(res[i], '.');
        }
        for(int i = box[0].length;i>=0;i--) {
            for(int j = 0; j<box.length;j++) {
                if (i == box[0].length || box[j][i] == '*') {
                    int size = 0;
                    int start = i - 1;
                    while (start >= 0 && box[j][start] != '*') {
                        if(box[j][start] == '#') {
                            size ++;
                        }
                        start--;
                    }
                    start = i-1;
                    while (size--!=0) {
                        res[start][box.length - 1 - j] = '#';
                        start--;
                    }
                    if(i != box[0].length) {
                        res[i][box.length - 1 - j] = '*';
                    }
                }
            }
        }
        return res;
    }
}
