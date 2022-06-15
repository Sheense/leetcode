package com.company.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 最多单词数的发件人
 * @Date 2022/5/28 10:34 下午
 * @Created by sheen
 * @Description TODO
 */
public class 最多单词数的发件人 {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < senders.length; i++) {
            int size = messages[i].split(" ").length;
            map.put(senders[i], map.getOrDefault(senders[i], 0) + size);
        }

        String name = "";
        int max = 0;
        for(String key : map.keySet()) {
            if(map.get(key) >= max) {
                if(map.get(key) == max) {
                    if(key.compareTo(name) < 0) {
                        continue;
                    }
                }
                name = key;
                max = map.get(key);

            }
        }

        return name;
    }
}
