package com.company.array;

public class 按键持续时间最长的键 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] time = new int[26];
        int max = 0;
        char res = ' ';
        for(int i=0;i<keysPressed.length();i++) {
            if(i==0) {
                time[keysPressed.charAt(i)-'a'] = releaseTimes[i];
            }else {
                time[keysPressed.charAt(i)-'a'] = releaseTimes[i] - releaseTimes[i-1];
            }
            if(max<=time[keysPressed.charAt(i)-'a']) {
                if(res==' '||max<time[keysPressed.charAt(i)-'a']||max==time[keysPressed.charAt(i)-'a']&&res<keysPressed.charAt(i)) {
                    max = time[keysPressed.charAt(i)-'a'];
                    res = keysPressed.charAt(i);
                }
            }
        }
        return res;
    }
}
