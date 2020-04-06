package com.company.hash;

import java.util.*;

public class 字母异位词分组 {

    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        字母异位词分组 s = new 字母异位词分组();
        System.out.println(s.groupAnagrams(str));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++) {
            String key = getKey(strs[i]);
            if(map.containsKey(key) ){
                map.get(key).add(strs[i]);
            }else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> list : map.values() ) {
            res.add(list);
        }
        return res;
    }

    public String getKey(String string) {
        char[] arr = string.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
