package sheen.leetcode.array;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

public class 保证文件名唯一 {

    public static void main(String[] args) {
        保证文件名唯一 s = new 保证文件名唯一();
        ArrayUtils.print(s.getFolderNames(new String[]{"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"}));
    }
    public String[] getFolderNames(String[] names) {
        String[] res = new String[names.length];
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i< names.length;i++) {
            if(!map.containsKey(names[i])) {
                map.put(names[i],0);
                res[i] = names[i];
            }else {
                int j = map.get(names[i])+1;
                String string = names[i] + "("+j+")";
                while(map.containsKey(string)) {
                    j++;
                    string = names[i] + "("+j+")";
                }
                map.put(names[i],j);
                map.put(string,0);
                res[i] = string;
            }
        }
        return res;
    }
}
