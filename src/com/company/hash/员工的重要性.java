package com.company.hash;

import java.util.*;

public class 员工的重要性 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(int i=0;i<employees.size();i++) {
            map.put(employees.get(i).id, employees.get(i));
        }
        int res = 0;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if(!set.contains(index)) {
                set.add(index);
                res+=map.get(index).importance;
                for(int i=0;i<map.get(index).subordinates.size();i++) {
                    queue.offer(map.get(index).subordinates.get(i));
                }
            }
        }
        return res;
    }
}
