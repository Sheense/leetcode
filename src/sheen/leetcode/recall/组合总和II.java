package sheen.leetcode.recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和II {


    public static void main(String[] args) {
        组合总和II s = new 组合总和II();
        System.out.println(s.combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        recall(res, new ArrayList<>(),candidates, target, 0, candidates.length-1);
        return res;
    }
    public void recall(List<List<Integer>> res, List<Integer> now,int[] candidates, int target, int num, int index) {
        if(index<0) {
            return;
        }
        int next = index-1;
        while(next>=0){
            if(candidates[next]==candidates[index]) next--;
            else break;
        }
        recall(res, now, candidates,target, num, next);


        if(num+candidates[index] == target) {
            List<Integer> list = new ArrayList<>(now);
            list.add(candidates[index]);
            res.add(list);
            return;
        }else if(num+candidates[index]>target){
            return;
        }else {
            List<Integer> list = new ArrayList<>(now);
            list.add(candidates[index]);
            recall(res, list, candidates , target , num+candidates[index] , index-1);
        }

    }

}
