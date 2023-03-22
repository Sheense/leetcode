package sheen.leetcode.recall;

/**
 * @Classname 得分最高的单词集合
 * @Date 2023/2/26 12:24 上午
 * @Created by sheen
 * @Description TODO
 */
public class 得分最高的单词集合 {


    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] arr = new int[26];
        for(int i = 0; i < letters.length; i++) {
            arr[letters[i] - 'a'] ++;
        }

        recall(words, arr, score, 0, 0);
        return res;
    }

    private int res = 0;
    public void recall(String[] words,  int[] arr, int[] score, int index, int num) {
        if(words.length == index) {
            res = Math.max(num, res);
            return;
        }
        recall(words, arr, score, index + 1, num);

        int count = 0;
        int i = 0;
        for(; i < words[index].length(); i++) {
            if(arr[words[index].charAt(i) - 'a'] > 0) {
                arr[words[index].charAt(i) - 'a']--;
                count += score[words[index].charAt(i) - 'a'];
            }else {
                break;
            }
        }

        if(i == words[index].length()) {
            recall(words, arr, score, index + 1, num + count);
        }

        for(i--; i >= 0; i--) {
            arr[words[index].charAt(i) - 'a']++;
        }

    }
}
