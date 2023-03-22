package sheen.leetcode.tree;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Classname 树上的操作
 * @Date 2021/9/4 11:21 下午
 * @Created by sheen
 * @Description TODO
 */
public class 树上的操作 {


    class LockingTree {


        private Map<Integer, Integer> map = new HashMap<>();
        private Map<Integer, Set<Integer>> children = new HashMap<>();
        private int parent[];
        public LockingTree(int[] parent) {
            for(int i = 0; i < parent.length; i++) {
                int key = i;
                while (parent[key] != -1) {
                    children.computeIfAbsent(parent[key], x -> new HashSet<>()).add(i);
                    key = parent[key];
                }
            }
            this.parent = parent;
        }

        public boolean lock(int num, int user) {
            if(map.containsKey(num)) {
                return false;
            }
            map.put(num, user);
            return true;
        }

        public boolean unlock(int num, int user) {
            if(map.containsKey(num) && map.get(num) == user) {
                map.remove(num);
                return true;
            }
            return false;
        }

        public boolean upgrade(int num, int user) {
            if(map.containsKey(num)) {
               return false;
            }

            boolean flag = false;
            int i = num;
            while (parent[i] != -1) {
                if(map.containsKey(parent[i])) {
                    flag = true;
                    break;
                }
                i = parent[i];
            }
            if(flag) {
                return false;
            }

            for(int child : children.getOrDefault(num, new HashSet<>())) {
                if(map.containsKey(child)) {
                    flag = true;
                    map.remove(child);
                }
            }
            if(!flag) {
                return false;
            }
            map.put(num, user);
            return true;
        }
    }
}
