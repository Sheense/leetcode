package sheen.leetcode.bitOperation;

import java.util.HashMap;
import java.util.Map;

public class 找出最长的超赞子字符串 {

    public static void main(String[] args) {
        找出最长的超赞子字符串 s = new 找出最长的超赞子字符串();
        System.out.println(s.longestAwesome("1127038731581921711218116700959264880942345890503910972735414296311053833364343544901"));
    }

    /*public int longestAwesome(String s) {
        if(s.length()==0) return 0;
        int cur = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        map.put(0, -1);
        int[] arr = new int[s.length()];
        int index = 0;
        for(int i=0;i<s.length();i++) {
            int item = 1<<(s.charAt(i)-'0');
            cur = item^cur;
            arr[index++] = cur;
            for(int j=0;j<10;j++) {
                int key = cur^(1<<j);
                if(map.containsKey(key)) {
                    max = Math.max(i - map.get(key), max);
                    if(max==73) {
                        System.out.println( map.get(key)+","+i);
                    }
                }
            }
            int finalI = i;
            max = Math.max(finalI - map.computeIfAbsent(cur, x -> finalI), max);
        }
        ArrayUtils.print(arr);
        return max;
    }*/

    public int longestAwesome(String s) {
        if(s.length()==0) return 0;
        int[] arr = new int[s.length()];
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for(int i=0;i<s.length();i++) {
            if(i==0) {
                arr[0] = (int)Math.pow(2, s.charAt(0)-'0');
                map.put(arr[0], 0);
                continue;
            }
            int item = (int)Math.pow(2,s.charAt(i)-'0');
            arr[i] = item^arr[i-1];
            int finalI = i;
            max = Math.max(i - map.computeIfAbsent(arr[i], x-> finalI), max);
            if(check(arr[i])) {
                max = Math.max(max, i+1);
                continue;
            }
            for(int j=0;j<10;j++) {
                int value = (int)Math.pow(2, j);
                int key = arr[i]^value;
                if(map.containsKey(key)) {
                    max = Math.max(max, i - map.get(key));
                }
            }
        }
        return max;
    }

    public boolean check(int value) {
        int count = 0;
        for(int i=0;i<10;i++) {
            if(((int)Math.pow(2, i)&value)!= 0) {
                count++;
            }
            if(count>1) return false;
        }
        return true;
    }


}
