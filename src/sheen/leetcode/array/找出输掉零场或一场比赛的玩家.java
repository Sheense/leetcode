package sheen.leetcode.array;

import java.util.*;

/**
 * @Classname 找出输掉零场或一场比赛的玩家
 * @Date 2024/5/22 00:20
 * @Created by sheen
 * @Description TODO
 */
public class 找出输掉零场或一场比赛的玩家 {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> win = new ArrayList<>();
        List<Integer> loss = new ArrayList<>();
        Map<Integer, Set<Integer>> lossMap = new HashMap<>();
        Set<Integer> winSet = new HashSet<>();
        for(int[] match : matches) {
            winSet.add(match[0]);
            lossMap.computeIfAbsent(match[1], x -> new HashSet<>()).add(match[0]);
        }

        for(int key : lossMap.keySet()) {
            if(lossMap.get(key).size() == 1) {
                loss.add(key);
            }
        }

        for(int key : winSet) {
            if(!lossMap.containsKey(key)) {
                win.add(key);
            }
        }

        Collections.sort(loss);
        Collections.sort(win);
        return Arrays.asList(win, loss);
    }
}
