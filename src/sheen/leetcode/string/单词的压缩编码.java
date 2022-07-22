package sheen.leetcode.string;

public class 单词的压缩编码 {

    public static void main(String[] args) {
        单词的压缩编码 s = new 单词的压缩编码();
        System.out.println(s.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }
    public int minimumLengthEncoding(String[] words) {
        sort(words, 0, words.length-1);
        int time = 1;
        int res = words[0].length();
        for(int i=1;i<words.length;i++) {
            boolean flag = true;
            for(int j=0;j<i;j++) {
                String item = words[j].substring(words[j].length()-words[i].length());
                if(item.equals(words[i])) {
                    flag =false;
                    break;
                }
            }
            if(flag) {
                time ++;
                res += words[i].length();
            }
        }
        return res+time;
    }
    public void sort(String[] words, int start, int end) {
        if(start>=end) return ;
        int left = start;
        int right = end;
        String key = words[left];
        while(left<right) {
            while(left<right&&words[right].length()<=key.length()) right--;
            words[left] = words[right];
            while(left<right&&words[left].length()>=key.length()) left++;
            words[right] = words[left];
        }
        words[left] = key;
        sort(words, start, left-1);
        sort(words, left+1, end);
    }
}
