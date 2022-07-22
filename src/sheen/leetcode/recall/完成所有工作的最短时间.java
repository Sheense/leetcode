package sheen.leetcode.recall;

import sheen.leetcode.util.ArrayUtils;

import java.util.*;

public class 完成所有工作的最短时间 {
    public static void main(String[] args) {
        完成所有工作的最短时间 s = new 完成所有工作的最短时间();


        System.out.println(s.minimumTimeRequired(new int[]{1,2,4,7,8},2));
    }

    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        for(int i=0;i<jobs.length/2;i++) {
            int item = jobs[i];
            jobs[i] = jobs[jobs.length - 1 - i];
            jobs[jobs.length - 1 - i] = item;
        }
        ArrayUtils.print(jobs);
        int l = jobs[0], r = Arrays.stream(jobs).sum();
        while (l <= r) {
            int mid = l + (r - l)/2;
            if(check(mid, jobs, new int[k], 0)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int limit, int[] jobs, int[] persons, int i) {
        if(i >= jobs.length) return true;
        int cur = jobs[i];
        for(int j = 0;j<persons.length;j++) {
            if(persons[j] + cur <= limit) {
                persons[j] += cur;
                if(check(limit, jobs, persons, i+1)) {
                    return true;
                }
                persons[j] -= cur;
            }
            //如果当前没有分配工作，而且还是false，那么下一工人拿的工作肯定会超过限制
            //如果当前的工人已经拿到刚好等于限制的工作，结果还是false，那么把工作放给下一个人肯定会超过限制
            if(persons[j] == 0 || persons[j] + cur == limit) {
                return false;
            }
        }
        return false;
    }

    /*public boolean check(int limit, List<Integer> persons, List<Integer> yu, int now) {
        if(now == yu.size()) return true;
        for(int i = 0;i<persons.size();i++) {
            if(persons.get(i) + yu.get(now) <= limit) {
                persons.set(i, persons.get(i) + yu.get(now));
                boolean res = check(limit, persons, yu, now+1);
                persons.set(i, persons.get(i) - yu.get(now));
                if(res) return res;
            }
        }
        return false;
    }*/

    /*public void recall(int k, List<Integer> now, List<List<Integer>> list, int index, int len) {
        if(index == len) {
            if(k == 0) {
                list.add(now);
            }
            return;
        }
        List<Integer> copy = new ArrayList<>(now);
        copy.add(index);
        recall(k-1, copy, list, index+1, len);
        recall(k, now, list, index+1, len);
    }*/


    /*public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        ArrayUtils.print(jobs);
        int low = 0, high = jobs.length - 1;
        while (low < high) {
            int temp = jobs[low];
            jobs[low] = jobs[high];
            jobs[high] = temp;
            low++;
            high--;
        }
        int l = jobs[0], r = Arrays.stream(jobs).sum();
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(jobs, k, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean check(int[] jobs, int k, int limit) {
        int[] workloads = new int[k];
        boolean flag = backtrack(jobs, workloads, 0, limit);
        ArrayUtils.print(workloads);
        System.out.println(limit);
        return flag;
    }

    public boolean backtrack(int[] jobs, int[] workloads, int i, int limit) {
        if (i >= jobs.length) {
            return true;
        }
        int cur = jobs[i];
        for (int j = 0; j < workloads.length; ++j) {
            if (workloads[j] + cur <= limit) {
                workloads[j] += cur;
                if (backtrack(jobs, workloads, i + 1, limit)) {
                    return true;
                }
                workloads[j] -= cur;
            }
            // 如果当前工人未被分配工作，那么下一个工人也必然未被分配工作
            // 或者当前工作恰能使该工人的工作量达到了上限
            // 这两种情况下我们无需尝试继续分配工作
            if (workloads[j] == 0 || workloads[j] + cur == limit) {
                break;
            }
        }
        return false;
    }*/
//2420271 3582365 3758448 4542202 5146275 7697968 8291115 8573153 9288480 9477657 9881935 9899456
}
