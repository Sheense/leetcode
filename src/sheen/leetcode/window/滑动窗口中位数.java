package sheen.leetcode.window;

import sheen.leetcode.util.ArrayUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
//双向优先队列+延迟删除
public class 滑动窗口中位数 {
    public static void main(String[] args) {
        滑动窗口中位数 s = new 滑动窗口中位数();
        ArrayUtils.print(s.medianSlidingWindow(new int[]{-2147483648,-2147483648,2147483647,-2147483648,-2147483648,
                -2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648}, 3));
    }
    /*public double[] medianSlidingWindow(int[] nums, int k) {
        if(k==1) {
            double[] res = new double[nums.length];
            for(int i=0;i<nums.length;i++) res[i] = nums[i];
            return res;
        }
        PriorityQueue<int[]> small = new PriorityQueue<>((o1, o2)-> {
            if(o2[1] - o1[1]!=0) {
                return o2[1] - o1[1];
            }else {
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<int[]> large = new PriorityQueue<>((o1, o2)-> {
            if(o1[1] - o2[1]!=0) {
                return o1[1] - o2[1];
            }else {
                return o1[0] - o2[0];
            }
        });
        for(int i=0;i<k;i++) {
            small.add(new int[]{i, nums[i]});
        }
        boolean isOdd = k % 2 == 1;
        int time = k/2;
        while(time--!=0) {
            large.add(small.poll());
        }
        double[] res = new double[nums.length-k+1];
        for(int i=0;i<=nums.length-k;i++) {
            if(i!=0) {
                int removeNum = nums[i-1];
                int newNum = nums[i+k-1];
                if(removeNum<small.peek()[1]||(removeNum==small.peek()[1]&&(i-1)==small.peek()[0])) {
                    while (!small.isEmpty()&&small.peek()[0]<i) {
                        small.poll();
                    }
                    while (!large.isEmpty()&&large.peek()[0]<i) {
                        large.poll();
                    }
                    if(newNum<=large.peek()[1]||(!small.isEmpty()&&newNum<=small.peek()[1])) {
                        small.add(new int[]{i+k-1, newNum});
                    }else {
                        small.add(large.poll());
                        large.add(new int[]{i+k-1, newNum});
                    }
                }else {
                    while (!small.isEmpty()&&small.peek()[0]<i) {
                        small.poll();
                    }
                    while (!large.isEmpty()&&large.peek()[0]<i) {
                        large.poll();
                    }
                    if(newNum>=small.peek()[1]||(!large.isEmpty()&&newNum>=large.peek()[1])) {
                        large.add(new int[]{i+k-1, newNum});
                    }else {
                        large.add(small.poll());
                        small.add(new int[]{i+k-1, newNum});
                    }
                }
            }
            if(isOdd) {
                res[i] = small.peek()[1];
            }else {
                res[i] = ((double)small.peek()[1]+large.peek()[1])/2;
            }
        }
        return res;
    }*/
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> small = new PriorityQueue<>((o1,o2)-> ((long)o2-(long)o1)<0?-1:1);
        PriorityQueue<Integer> large = new PriorityQueue<>((o1,o2)-> ((long)o1-(long)o2)<0?-1:1);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<k;i++) {
            small.add(nums[i]);
        }
        boolean isOdd = k % 2 == 1;
        int time = k/2;
        while(time--!=0) {
            large.add(small.poll());
        }
        double[] res = new double[nums.length-k+1];
        for(int i=0;i<=nums.length-k;i++) {
            if(i!=0) {
                int oldValue = nums[i-1];
                map.put(oldValue, map.getOrDefault(oldValue, 0)+1);
                int balance = 0;
                int newValue = nums[k+i-1];
                if (oldValue<=small.peek()) {
                    balance--;
                }else {
                    balance++;
                }
                if(newValue<=small.peek()) {
                    small.add(newValue);
                    balance++;
                }else {
                    large.add(newValue);
                    balance--;
                }

                if(balance>0) {
                    large.add(small.poll());
                }else if(balance<0) {
                    small.add(large.poll());
                }

                while(!small.isEmpty()&&map.getOrDefault(small.peek(), 0)>0) {
                    map.put(small.peek(), map.get(small.peek())-1);
                    small.poll();
                }
                while(!large.isEmpty()&&map.getOrDefault(large.peek(),0)>0) {
                    map.put(large.peek(), map.get(large.peek())-1);
                    large.poll();
                }
            }
            if(isOdd) {
                res[i] = small.peek();
            }else {
                res[i] = ((double)small.peek()+large.peek())/2;
            }
        }
        return res;
    }

}
