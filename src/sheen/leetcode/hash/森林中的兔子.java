package sheen.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class 森林中的兔子 {
    public static void main(String[] args) {
        森林中的兔子 s = new 森林中的兔子();
        System.out.println(s.numRabbits(new int[]{0,0,1,1,1}));
    }
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<answers.length;i++) {
            if(answers[i] == 0) {
                res++;
                continue;
            }
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }

        for(int key : map.keySet()) {
            if(key+1<map.get(key)) {
                int value = map.get(key);
                while (value>key+1) {
                    res += key+1;
                    value -= (key+1);
                }
                if(value!=0) {
                    res += key+1;
                }
            }else {
                res += key+1;
            }
        }
        return res;
    }
}
