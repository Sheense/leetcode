package sheen.leetcode.array;

/**
 * @Classname 最短补全词
 * @Date 2021/12/10 12:02 上午
 * @Created by sheen
 * @Description TODO
 */
public class 最短补全词 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] arr = new int[26];
        for(int i = 0; i < licensePlate.length(); i++) {
            if(licensePlate.charAt(i) == ' ' || (licensePlate.charAt(i) >= '0' && licensePlate.charAt(i) <= '9')) {
                continue;
            }

            if(licensePlate.charAt(i) >= 'a' && licensePlate.charAt(i) <= 'z') {
                arr[licensePlate.charAt(i) - 'a'] ++;
            }
            if(licensePlate.charAt(i) >= 'A' && licensePlate.charAt(i) <= 'Z') {
                arr[licensePlate.charAt(i) - 'A']++;
            }
        }
        int minLen = Integer.MAX_VALUE;
        int minInd = 0;
        for(int i = 0; i < words.length; i++) {
            int[] temp = new int[26];
            for(int j = 0; j < words[i].length(); j++) {
                temp[words[i].charAt(j) - 'a']++;
            }
            boolean flag = true;
            for(int j = 0; j < temp.length; j++) {
                if(arr[j] > temp[j]) {
                    flag = false;
                    break;
                }
            }

            if(flag && minLen > words[i].length()) {
                minLen = words[i].length();
                minInd = i;
            }
        }
        return words[minInd];
    }
}
