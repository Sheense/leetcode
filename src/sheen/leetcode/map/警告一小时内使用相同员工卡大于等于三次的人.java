package sheen.leetcode.map;

import java.util.*;

/**
 * @Classname 警告一小时内使用相同员工卡大于等于三次的人
 * @Date 2023/2/7 12:08 上午
 * @Created by sheen
 * @Description TODO
 */
public class 警告一小时内使用相同员工卡大于等于三次的人 {
    public static void main(String[] args) {
        警告一小时内使用相同员工卡大于等于三次的人 s = new 警告一小时内使用相同员工卡大于等于三次的人();
        System.out.println(s.alertNames(new String[]{"a","a","a","a","a","a","b","b","b","b","b"},
                new String[]{"23:27","03:14","12:57","13:35","13:18","21:58","22:39","10:49","19:37","14:14","10:41"}));
    }
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = sort(keyName, keyTime);
        List<String> res = new ArrayList<>();
        for(String name : map.keySet()) {
            List<Integer> list = map.get(name);
            if(list.size() <= 2) {
                continue;
            }
            int j = 0;
            int firstIndex = 0;
            while (j < list.size()) {
                if(list.get(j) - list.get(firstIndex) <= 60) {
                    if(j - firstIndex + 1 == 3) {
                        res.add(name);
                        break;
                    }
                }else {
                    while (firstIndex < j && list.get(j) - list.get(firstIndex) > 60) {
                        firstIndex++;
                    }
                }
                j++;
            }

        }

        Collections.sort(res);
        return res;
    }



    public Map<String, List<Integer>> sort(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> res = new HashMap<>();
        for(int i = 0; i < keyName.length; i++) {
            int[] value = transfer(keyTime[i]);
            res.computeIfAbsent(keyName[i], x -> new ArrayList<>()).add(value[0] * 60 + value[1]);
        }

        for(List<Integer> item : res.values()) {
            Collections.sort(item);
        }

        return res;
    }

    public int[] transfer(String v) {
        String[] item = v.split(":");
        return new int[]{Integer.parseInt(item[0]), Integer.parseInt(item[1])};
    }
}
