package sheen.leetcode.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Classname 子域名访问计数
 * @Date 2022/10/5 12:22 上午
 * @Created by sheen
 * @Description TODO
 */
public class 子域名访问计数 {
    public static void main(String[] args) {
        子域名访问计数 s = new 子域名访问计数();
        System.out.println(s.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < cpdomains.length; i++) {
            String[] arr = cpdomains[i].split(" ");
            int count = Integer.valueOf(arr[0]);
            String[] items = arr[1].split("\\.");
            if(items.length >= 3) {
                map.put(items[2], map.getOrDefault(items[2], 0) + count);
                map.put(items[1] + "." + items[2], map.getOrDefault(items[1] + "." + items[2], 0) + count);
                map.put(items[0] + "." + items[1] + "." + items[2], map.getOrDefault(items[0] + "." + items[1] + "." + items[2], 0) + count);
            }else if(items.length == 2) {
                map.put(items[1], map.getOrDefault(items[1], 0) + count);
                map.put(items[0] + "." + items[1], map.getOrDefault(items[0] + "." + items[1], 0) + count);
            }else {
                map.put(items[0], map.getOrDefault(items[0], 0) + count);
            }
        }
        List<String> res = new LinkedList<>();
        for(String key : map.keySet()) {
            res.add(map.get(key) + " " + key);
        }

        return res;
    }
}
