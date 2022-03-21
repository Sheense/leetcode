package com.company.list;

import com.company.common.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Classname 链表随机节点
 * @Date 2022/1/16 11:39 上午
 * @Created by sheen
 * @Description TODO
 */
public class 链表随机节点 {
    static class Solution {

        private Map<Integer, Integer> map = new HashMap<>();
        private int size = 0;
        private Random random = new Random();
        public Solution(ListNode head) {
            while (head != null) {
                map.put(size, head.val);
                head = head.next;
                size++;
            }
        }

        public int getRandom() {
            return map.get(random.nextInt(size));
        }
    }
}
