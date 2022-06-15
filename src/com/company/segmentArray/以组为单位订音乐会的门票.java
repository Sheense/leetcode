package com.company.segmentArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @Classname 以组为单位订音乐会的门票
 * @Date 2022/5/28 11:10 下午
 * @Created by sheen
 * @Description TODO
 */
public class 以组为单位订音乐会的门票 {
    public static void main(String[] args) {
        BookMyShow s = new BookMyShow(3, 999999999);
        s.scatter(1000000000,2);
        s.gather(999999999, 2);
        s.gather(999999999, 2);
        s.gather(999999999, 2);
    }
    static class BookMyShow {
        private int m;
        private int n;
        private long[] sum;
        private long[] min;

        public BookMyShow(int n, int m) {
            this.m = m;
            this.n = n;
            this.sum = new long[n * 4];
            this.min = new long[n * 4];
        }

        public int[] gather(int k, int maxRow) {
            int index = index(1, 1, n, maxRow + 1, m - k);
            if(index == 0) {
                return new int[]{};
            }
            int seat = (int)querySum(1, 1, n, index, index);
            add(1, 1, n, index, k);

            return new int[]{index - 1, seat};
        }

        public boolean scatter(int k, int maxRow) {
            if((maxRow + 1) * (long)m - querySum(1, 1, n, 1, maxRow + 1) < k) {
                return false;
            }

            for(int i = index(1, 1, n, maxRow + 1,m - 1);;i++) {
                if(i == 0) {
                    return false;
                }
                int seats = m - (int)querySum(1, 1, n, i , i);
                if(k <= seats) {
                    add(1, 1, n, i, k);
                    return true;
                }
                k -= seats;
                add(1, 1, n, i, seats);
            }
        }

        public void add(int index, int l, int r, int target, int val) {
            if(l == r) {
                sum[index] += val;
                min[index] += val;
                return;
            }

            int mid = (l + r) / 2;
            if(mid >= target) {
                add(index * 2, l , mid, target, val);
            }else {
                add(index * 2 + 1, mid + 1, r, target, val);
            }
            sum[index] = sum[index * 2] + sum[index * 2 + 1];
            min[index] = Math.min(min[index * 2], min[index * 2 + 1]);
        }

        public long querySum(int index, int l, int r, int L, int R) {
            if(L <= l && r <= R) {
                return sum[index];
            }

            int mid = (l + r) / 2;
            long sum = 0;
            if(mid >= L) {
                sum += querySum(index * 2, l, mid, L, R);
            }
            if(mid < R) {
                sum += querySum(index * 2 + 1, mid + 1, r, L, R);
            }

            return sum;
        }


        public int index(int index, int l, int r, int maxR, int val) {
            if(min[index] > val) return 0;
            if(l == r) {
                return l;
            }

            int mid = (l + r) / 2;
            int left = index(index * 2, l , mid, maxR, val);
            if(left != 0) {
                return left;
            }
            if(maxR >= mid + 1) {
                return index(index * 2 + 1, mid + 1, r, maxR, val);
            }

            return 0;
        }
    }
}
