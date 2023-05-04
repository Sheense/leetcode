package sheen.leetcode.dp;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

/**
 * @Classname 最小的必要团队
 * @Date 2023/4/8 12:49 下午
 * @Created by sheen
 * @Description TODO
 */
public class 最小的必要团队 {
    public static void main(String[] args) {
        最小的必要团队 s = new 最小的必要团队();
        ArrayUtils.print(s.smallestSufficientTeam(new String[]{"algorithms","math","java","reactjs","csharp","aws"},
                Arrays.asList(Arrays.asList("algorithms","math","java"),
                        Arrays.asList("algorithms","math","reactjs"),
                        Arrays.asList("java","csharp","aws"),
                        Arrays.asList("reactjs","csharp"),
                        Arrays.asList("csharp","math"),
                        Arrays.asList("aws","java"))));
    }
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int n = (1 << req_skills.length) - 1;
        Map<String, Integer> index = new HashMap<>();
        for(int i = 0; i < req_skills.length; i++) {
            index.put(req_skills[i], i);
        }

        Map<Integer, Integer> peopleMap = new HashMap<>();
        for(int i = 0; i < people.size(); i++) {
            int item = 0;
            for(String skill : people.get(i)) {
                item |= (1 << index.get(skill));
            }

            //相同要求技能保留一个
            peopleMap.put(item, i);
        }

        map.put(0, new HashSet<>());
        for(int i = 1; i <= n; i++) {
            for(Map.Entry<Integer, Integer> entry : peopleMap.entrySet()) {
                int peopleSkills = entry.getKey();
                int peopleIndex = entry.getValue();
                if((peopleSkills & i) > 0) {
                    //符合要求的技能
                    int has = peopleSkills & i;
                    //欠缺的技能
                    int noHas = has ^ i;
                    if(map.containsKey(noHas)) {
                        int size = (map.get(noHas).contains(peopleIndex) ? 0 : 1) + map.get(noHas).size();
                        if(!map.containsKey(i) || map.get(i).size() > size) {
                            Set<Integer> set = new HashSet<>(map.get(noHas));
                            set.add(peopleIndex);
                            map.put(i, set);
                        }
                    }
                }
            }

        }

        int[] res = new int[map.get(n).size()];
        int q = 0;
        for(int i : map.get(n)) {
            res[q++] = i;
        }
        return res;
    }
}
