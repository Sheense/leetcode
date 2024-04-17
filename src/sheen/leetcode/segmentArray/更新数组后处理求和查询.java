package sheen.leetcode.segmentArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 更新数组后处理求和查询
 * @Date 2023/7/26 00:51
 * @Created by sheen
 * @Description TODO
 */
public class 更新数组后处理求和查询 {
    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        List<Long> res = new ArrayList<>();
        long numAll = 0;
        for(int i = 0; i < nums2.length; i++) {
            numAll += nums2[i];
        }

        SegTree tree = new SegTree(nums1);
        for(int i = 0; i < queries.length; i++) {
            if(queries[i][0] == 1) {
                tree.reverseRange(queries[i][1], queries[i][2]);
            }else if(queries[i][0] == 2) {
                numAll += (long) tree.query(0, nums1.length - 1) * queries[i][1];
            }else {
                res.add(numAll);
            }
        }


        if(res.size() == 0) {
            return new long[]{};
        }

        long[] ans = new long[res.size()];
        for(int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static class SegTree{

        private SegNode[] tree;
        private int[] nums;
        public SegTree(int[] nums) {
            this.nums = nums;
            this.tree = new SegNode[nums.length * 4 + 1];
            build(1, 0, nums.length - 1);
        }

        private void build(int id, int left, int right) {
            this.tree[id] = new SegNode();
            this.tree[id].l = left;
            this.tree[id].r = right;

            if(left == right) {
                this.tree[id].sum = nums[left];
                return;
            }
            int mid = (left + right) / 2;
            build(id * 2, left, mid);
            build(id * 2 + 1, mid + 1, right);
            this.tree[id].sum = this.tree[id * 2].sum + this.tree[id * 2 + 1].sum;
        }

        private void update(int id) {
            if(this.tree[id].lazy) {
                this.tree[id * 2].sum = this.tree[id * 2].r - this.tree[id * 2].l + 1 - this.tree[id * 2].sum;
                this.tree[id * 2 + 1].sum = this.tree[id * 2 + 1].r - this.tree[id * 2 + 1].l + 1 - this.tree[id * 2 + 1].sum;
                this.tree[id * 2].lazy = !this.tree[id * 2].lazy;
                this.tree[id * 2 + 1].lazy = !this.tree[id * 2 + 1].lazy;
                this.tree[id].lazy = false;
            }
        }

        public void reverseRange(int left, int right) {
            modify(1, left, right);
        }

        public int query(int left, int right) {
            return search(1, left, right);
        }

        private int search(int id, int left, int right) {
            if(this.tree[id].l >= left && this.tree[id].r <= right) {
                return this.tree[id].sum;
            }

            if(this.tree[id].r < left || this.tree[id].l > right) {
                return 0;
            }

            int res = 0;
            update(id);
            if(this.tree[id * 2].r >= left) {
                res += search(id * 2, left, right);
            }
            if(this.tree[id * 2 + 1].l <= right) {
                res +=search(id * 2 + 1, left, right);
            }

            return res;
        }

        private void modify(int id, int left, int right) {
            if(this.tree[id].l <= left && this.tree[id].r >= right) {
                this.tree[id].sum = this.tree[id].r - this.tree[id].l + 1 - this.tree[id].sum;
                this.tree[id].lazy = !this.tree[id].lazy;
                return;
            }

            update(id);

            if(this.tree[id * 2].r >= left) {
                modify(id * 2, left, right);
            }
            if(this.tree[id * 2 + 1].l <= right) {
                modify(id * 2 + 1, left, right);
            }

            this.tree[id].sum = this.tree[id * 2].sum + this.tree[id * 2 + 1].sum;
        }
    }

    public static class SegNode{
        private int l;
        private int r;
        private int sum;
        private boolean lazy;
    }
}
