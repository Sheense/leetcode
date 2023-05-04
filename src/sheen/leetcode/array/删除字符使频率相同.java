package sheen.leetcode.array;

/**
 * @Classname 删除字符使频率相同
 * @Date 2023/4/29 12:26 上午
 * @Created by sheen
 * @Description TODO
 */
public class 删除字符使频率相同 {
    public static void main(String[] args) {
        删除字符使频率相同 s = new 删除字符使频率相同();
        s.equalFrequency("aazz");
    }
    public boolean equalFrequency(String word) {
        if(word.length() == 1) {
            return true;
        }
        int[] arr = new int[26];
        for(int i = 0; i < word.length(); i++) {
            arr[word.charAt(i) - 'a']++;
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                boolean flag = true;
                arr[i] --;
                int a = -1;
                for(int j = 0; j < arr.length; j++) {
                    if(arr[j] != 0) {
                        if(a == -1) {
                            a = arr[j];
                        }else if(a != arr[j]) {
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag) {
                    return true;
                }
                arr[i] ++;
            }
        }
        return false;
    }
}
