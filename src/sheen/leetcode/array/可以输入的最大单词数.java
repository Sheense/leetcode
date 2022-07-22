package sheen.leetcode.array;

/**
 * @Classname 可以输入的最大单词数
 * @Date 2021/7/18 11:33 上午
 * @Created by sheen
 * @Description TODO
 */
public class 可以输入的最大单词数 {
    public static void main(String[] args) {
        可以输入的最大单词数 s = new 可以输入的最大单词数();
        s.canBeTypedWords("hello world", "ad");
    }
    public int canBeTypedWords(String text, String brokenLetters) {
        int res = 0;
        String texts[] = text.split(" ");
        for(int i = 0; i < texts.length; i++) {
            boolean flag = true;
            for (int j = 0; j < brokenLetters.length(); j++) {
                if(texts[i].contains(String.valueOf(brokenLetters.charAt(j)))) {
                    flag = false;
                    break;
                }
            }
            if(flag) res++;
        }
        return res;
    }
}
