package sheen.algorithm.demo;

/**
 * @Classname 线段树
 * @Date 2022/7/21 11:46 上午
 * @Created by sheen
 * @Description https://www.desgard.com/algo/docs/part3/ch02/3-segment-tree-range/
 */
public class 线段树 {

    public static void main(String[] args) {
        RangeCalculate rangeCalculate = new RangeCalculate(8);
        rangeCalculate.add(1, 3, 8);
        rangeCalculate.add(2, 3, 1);
        System.out.println(rangeCalculate.query(1, 3));
    }

    public static class RangeCalculate{
        private int size = 0;
        private int[] add; //懒加载
        private int[] sum;
        public RangeCalculate(int size) {
            this.size = size;
            add = new int[size * 4 + 1];
            sum = new int[size * 4 + 1];
        }

        public void add(int L, int R, int val) {
            add(L, R, 1, size, val, 1);
        }

        public int query(int L, int R) {
            return querySum(L, R, 1, size, 1);
        }

        private void add(int L, int R, int l, int r, int val, int index) {
            if(l == L && R == r) {
                add[index] += val;
                sum[index] += val * (R - L + 1);
                return;
            }

            int mid = (l + r) >> 1;
            pushDown(index, l,  r); //懒加载
            if(R <= mid) {
                add(L, R, l, mid, val, index << 1);
            }else if(L > mid) {
                add(L, R, mid + 1, r, val, (index << 1) | 1);
            }else {
                add(L, mid, l, mid, val, index << 1);
                add(mid + 1, R, mid + 1, r, val, (index << 1) | 1);
            }
            sum[index] = sum[index << 1] + sum[(index << 1) | 1];
        }

        private int querySum(int L, int R, int l, int r, int index) {
            if(L <= l && r <= R) {
                return sum[index];
            }
            pushDown(index, l, r); //懒加载
            int mid = (l + r) >> 1;
            if(R <= mid) {
                return querySum(L, R, l, mid, index << 1);
            }else if(L > mid) {
                return querySum(L, R, mid + 1, r, (index << 1) | 1);
            }else {
                return querySum(L, R, l, mid, index << 1) + querySum(L, R, mid + 1, r, (index << 1) | 1);
            }
        }

        private void pushDown(int index, int l, int r) {
            if(add[index] > 0) {
                int mid = (l + r) >> 1;
                add[index << 1] += add[index];
                add[(index << 1) | 1] += add[index];
                sum[index << 1] += add[index] * (mid - l + 1);
                sum[(index << 1) | 1] += add[index] * (r - mid);
                add[index] = 0;
            }
        }
    }
}
