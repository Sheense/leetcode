package sheen.leetcode.window;

import java.util.HashMap;
import java.util.Map;

public class K个不同整数的子数组 {
    public static void main(String[] args) {
        K个不同整数的子数组 s = new K个不同整数的子数组();
        System.out.println(s.subarraysWithKDistinct(new int[]{1,2,1,2,3},2));
    }
    public int subarraysWithKDistinct(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while(right<A.length) {
            int min = -1;
            while(map.size()<=K&&right<A.length) {
                if(!map.containsKey(A[right])&&map.size()==K) {
                    break;
                }
                if(map.size()<K) {
                    map.put(A[right], map.getOrDefault(A[right], 0)+1);
                }
                if(map.size()==K&&min==-1) {
                    min = right;
                }
                right++;
            }
            int max = right-1;
            while(min<=max&&map.size()==K) {
                res += max-min+1;
                int num = map.get(A[left]);
                num--;
                if(num==0) {
                    min++;
                   while(min<=max&&A[min]!=A[left]) {
                       map.put(A[min] ,map.getOrDefault(A[min],0)+1);
                       min++;
                   }
                   if(min>max) {
                       map.remove(A[left]);
                   }
                }else {
                    map.put(A[left], num);
                }
                left++;
            }
            /*while(left<right&&(map.size()==K||right==A.length)) {
                int num = map.get(A[left]);
                num--;
                if(num==0) {
                    map.remove(A[left]);
                }else {
                    map.put(A[left], num);
                }
                left++;
            }*/
        }
        return res;
    }
}
