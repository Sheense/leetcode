package sheen.algorithm.demo;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

/**
 * @Classname Main
 * @Date 2023/3/5 11:12 上午
 * @Created by sheen
 * @Description TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        if(M > 10 || M < 0) {
            print(new int[][]{});
            return;
        }
        HashSet[] list = new HashSet[M];
        for(int i = 0; i < M; i++) {
            String[] strs = in.next().split(",");
            if(strs.length > 100) {
                print(new int[][]{});
                return;
            }
            HashSet<Integer> set = new HashSet<>();
            list[i] = set;
            for(int j = 0; j < strs.length; j++) {
                set.add(Integer.parseInt(strs[j]));
            }
        }
        UnionSet unionSet = new UnionSet(list);
        int len;
        do{
            len = unionSet.getLen();
            for(int i = 0; i < list.length; i++) {
                for(int j = 0; j < list.length; j++) {
                    unionSet.union(i, j);
                }
            }
        }while (len != unionSet.getLen());

        print(unionSet.getRes());

    }

    public static void print(int[][] arr) {
        if(arr.length == 0) {
            System.out.println("[[]]");
            return;
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            String item = "[";
            for(int j = 0; j < arr[i].length; j++) {
                item += arr[i][j];
                if(j != arr[i].length - 1) {
                    item += ",";
                }
            }
            item += "]";
            res.add(item);
        }

        String print = "[";
        for(int i = 0; i < res.size(); i++) {
            print += res.get(i);
            if(i != res.size() - 1) {
                print += ",";
            }
        }
        print += "]";
        System.out.println(print);
    }

    public static class UnionSet{
        private HashSet[] list;
        private int[] pre;
        private int len;
        public UnionSet(HashSet[] list) {
            this.list = list;
            pre = new int[list.length];
            for(int i = 0; i < pre.length; i++) {
                pre[i] = i;
            }
            len = pre.length;
        }

        public void union(int i, int j) {
            if(check(i, j)) {
                int r1 = findRoot(i);
                int r2 = findRoot(j);
                if(r1 != r2) {
                    if(r1 < r2) {
                        pre[r2] = r1;
                        list[r1].addAll(list[r2]);
                    }else {
                        pre[r1] = r2;
                        list[r2].addAll(list[r1]);
                    }
                    len--;
                }
            }
        }

        public int findRoot(int i) {
            while (pre[i] != i) {
                i = pre[i];
            }

            return i;
        }

        public boolean check(int i, int j) {
            HashSet<Integer> set1 = list[i];
            HashSet<Integer> set2 = list[j];
            int count = 0;
            for(int v : set2) {
                if(set1.contains(v)) {
                    count++;
                }
                if(count >= 2) {
                    return true;
                }
            }
            return false;
        }

        public int getLen() {
            return len;
        }

        public int[][] getRes() {
            int len = 0;
            for(int i = 0; i < pre.length; i++) {
                if(pre[i] == i) {
                    len++;
                }
            }

            int[][] arr = new int[len][];
            int index = 0;
            for(int i = 0; i < pre.length; i++) {
                if(pre[i] == i) {
                    ArrayList<Integer> l = new ArrayList<>(list[i]);
                    Collections.sort(l);
                    int[] item = new int[l.size()];
                    for(int j = 0; j < l.size(); j++)  {
                        item[j] = l.get(j);
                    }
                    arr[index++] = item;
                }
            }
            return arr;
        }
    }
}
