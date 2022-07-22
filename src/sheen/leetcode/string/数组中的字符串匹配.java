package sheen.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class 数组中的字符串匹配 {
    public static void main(String[] args) {
        数组中的字符串匹配 s = new 数组中的字符串匹配();
        System.out.println(s.stringMatching(new String[]{"leetcoder","leetcode","od","hamlet","am"}));
    }

    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        if(words.length==0||words.length==1) return res;
         sort(words, 0,words.length-1);
         for(int i=1;i<words.length;i++) {
             for(int j=i-1;j>=0;j--) {
                 if(words[i].length() == words[j].length()) {
                     continue;
                 }
                 if(words[j].contains(words[i])) {
                     res.add(words[i]);
                     break;
                 }
             }
         }
         return res;
    }

    public void sort(String [] arr, int start, int end) {
        if(start>=end) return ;
        int left = start;
        int right = end;
        String key = arr[start];
        while(left<right) {
            while(left<right&&arr[right].length()<=key.length())  right--;
            arr[left] = arr[right];
            while(left<right&&arr[left].length()>=key.length()) left++;
            arr[right] = arr[left];
        }
        arr[left] = key;
        sort(arr, start,left-1);
        sort(arr, left+1, end);
    }
}
