package sheen.leetcode.segmentArray;

/**
 * @Classname 区域和检索_数组可修改
 * @Date 2022/4/4 12:07 上午
 * @Created by sheen
 * @Description TODO
 */
public class 区域和检索_数组可修改 {
    public static void main(String[] args) {
        NumArray s = new NumArray(new int[]{-1});
        System.out.println(s.sumRange(0 , 0));
        s.update(0, 1);
        System.out.println(s.sumRange(0, 0));
    }
    static class NumArray {

        private int[] tree;
        private int[] nums;
        public NumArray(int[] nums) {
            this.tree = new int[nums.length * 4];
            this.nums = nums;
            buildTree(0, nums.length - 1, 0);
        }

        public void update(int index, int val) {
            update(0, nums.length - 1, index, val, 0);
        }

        public int sumRange(int left, int right) {
            return range(left, right, 0, this.nums.length - 1, 0);
        }

        private int range(int left, int right, int s, int e, int node) {
            if(left == s && right == e) {
                return this.tree[node];
            }
            int m = s + (e - s) / 2;
            if(left <= m) {
                if(right <= m) {
                    return range(left, right, s, m, node * 2 + 1);
                }else {
                    return range(left, m, s, m, node * 2 + 1) + range(m + 1, right, m + 1, e, node * 2 + 2);
                }
            }else {
                return range(left, right, m + 1, e, node * 2 + 2);
            }
        }

        private void update(int s, int e, int index, int val, int node) {
            if(s == index && e == index) {
                this.tree[node] = val;
                return;
            }

            int m = s + (e - s) / 2;
            if(index >= s && index <= m) {
                this.tree[node] -= this.tree[node * 2 + 1];
                update(s, m, index, val, node * 2 + 1);
                this.tree[node] += this.tree[node * 2 + 1];
            }else{
                this.tree[node] -= this.tree[node * 2 + 2];
                update(m + 1, e, index, val, node * 2 + 2);
                this.tree[node] += this.tree[node * 2 + 2];
            }
        }

        private void buildTree(int s, int e, int node) {
            if(s == e) {
                this.tree[node] = this.nums[s];
                return;
            }

            int m = s + (e - s) / 2;
            buildTree(s, m, node * 2 + 1);
            buildTree(m + 1, e, node * 2 + 2);
            this.tree[node] = this.tree[node * 2 + 1] + this.tree[node * 2 + 2];
        }
    }

}
