package sheen.leetcode.recall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname 单词搜索II
 * @Date 2021/9/16 12:41 上午
 * @Created by sheen
 * @Description TODO
 */
public class 单词搜索II {
    public static void main(String[] args) {
        单词搜索II s = new 单词搜索II();
       /* System.out.println(s.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]{"oath","pea","eat","rain"}));*/
        System.out.println(s.findWords(new char[][]{{'a'}}, new String[]{"a"}));
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                map.computeIfAbsent(board[i][j], x -> new ArrayList<>()).add(i * board[i].length + j);
            }
        }
        for(int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i].charAt(0))) {
                for(int num : map.get(words[i].charAt(0))) {
                    int row = num / board[0].length;
                    int column = num % board[0].length;
                    boolean flag = recall(words[i], board, 0, row, column, new boolean[board.length][board[0].length]);
                    if(flag) {
                        res.add(words[i]);
                        break;
                    }
                }
            }
        }
        return res;
    }

    public boolean recall(String item, char[][] board, int index, int i, int j, boolean[][] check) {
        if(board[i][j] != item.charAt(index)) return false;

        if(index + 1 == item.length()) return true;
        check[i][j] = true;

        if(i - 1 >= 0 && !check[i - 1][j]) {
            boolean res = recall(item, board, index+1, i - 1, j, check);
            if(res) return true;
        }

        if(i + 1 < board.length && !check[i + 1][j]) {
            boolean res = recall(item, board, index+1, i + 1, j, check);
            if(res) return true;
        }

        if(j - 1 >= 0 && !check[i][j - 1]) {
            boolean res = recall(item, board, index+1, i, j - 1, check);
            if(res) return true;
        }

        if(j + 1 < board[0].length && !check[i][j + 1] ) {
            boolean res = recall(item, board, index+1, i, j + 1, check);
            if(res) return true;
        }

        check[i][j] = false;

        return false;
    }
}
