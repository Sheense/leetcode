package sheen.leetcode.trie;

/**
 * @Classname 统计异或值在范围内的数对有多少
 * @Date 2023/1/5 2:54 下午
 * @Created by sheen
 * @Description TODO
 */
public class 统计异或值在范围内的数对有多少 {
    public static void main(String[] args) {
        统计异或值在范围内的数对有多少 s = new 统计异或值在范围内的数对有多少();
        System.out.println(s.countPairs(new int[]{1,4,2,7}, 2, 6));
    }
    public int countPairs(int[] nums, int low, int high) {
        String[] valStrs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            valStrs[i] = transfer(nums[i]);
        }

        String highStr = transfer(high + 1);
        String lowStr = transfer(low);
        return getCount(highStr, valStrs) - getCount(lowStr, valStrs);
    }

    public int getCount(String x, String[] nums) {
        Node[] tree = new Node[2];
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
           if(i > 0) {
               res += getOx(tree, x, nums[i]);
           }
           add(tree, nums[i], 0);
        }

        return res;
    }

    public int getOx(Node[] tree, String x, String num) {
        Node[] next = tree;
        int res = 0;
        for(int i = 0; i < x.length(); i++) {
            char c1 = x.charAt(i);
            char c2 = num.charAt(i);
            if(c1 == '0') {
                if(c2 == '0') {
                    if(next[0] == null) {
                        break;
                    }
                    next = next[0].nodes;
                }else {
                    if(next[1] == null) {
                        break;
                    }
                    next = next[1].nodes;
                }
            } else {
                if(c2 == '1') {
                    if(next[1] != null) {
                        res += next[1].count;
                    }

                    if(next[0] == null) {
                        break;
                    }
                    next = next[0].nodes;
                }else {
                    if(next[0] != null) {
                        res += next[0].count;
                    }

                    if(next[1] == null) {
                        break;
                    }
                    next = next[1].nodes;
                }
            }
        }

        return res;
    }

    public void add(Node[] tree, String num, int index) {
        if(index >= num.length()) return;
        int i = num.charAt(index) - '0';
        if(tree[i] == null) {
            tree[i] = new Node();
        }

        tree[i].count ++;
        add(tree[i].nodes, num, index + 1);
    }



    public String transfer(int val) {
        String res = "";
        while (val > 0) {
            int item = val % 2;
            val /= 2;
            res = item + res;
        }

        if(res.length() < 15);
        while (res.length() < 15) {
            res = "0" + res;
        }

        return res;
    }

    public static class Node {
        int count = 0;
        Node[] nodes = new Node[2];
    }
}
