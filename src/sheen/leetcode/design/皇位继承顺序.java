package sheen.leetcode.design;

import java.util.*;

public class 皇位继承顺序 {
    class ThroneInheritance {

        private Person first;
        Map<String, Person> map = new HashMap<>();
        public ThroneInheritance(String kingName) {
            first = new Person();
            first.name = kingName;
            map.put(kingName, first);
        }

        public void birth(String parentName, String childName) {
            Person person = map.get(parentName);
            Person child = new Person();
            child.name = childName;
            person.children.add(child);
            map.put(childName, child);
        }

        public void death(String name) {
            map.get(name).status = -1;
        }

        public List<String> getInheritanceOrder() {
            Stack<Person> stack = new Stack<>();
            List<String> res = new ArrayList<>();
            stack.push(first);
            while (!stack.isEmpty()) {
               Person item = stack.pop();
               for(int i = item.children.size() - 1; i>=0 ;i--) {
                   stack.push(item.children.get(i));
               }
               if(item.status != 1) {
                   res.add(item.name);
               }
            }
            return res;
        }
    }

    public static class Person{
        String name;
        List<Person> children = new ArrayList<>();
        int status = 0;
    }
}
