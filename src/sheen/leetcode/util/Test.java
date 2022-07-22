package sheen.leetcode.util;

import sheen.leetcode.hash.LFUCache;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        /*List<Person> list = new ArrayList<>();
        list.stream().collect(Collectors.toMap(x -> x.sex, x->{
            List<String> l = new ArrayList<>();
            l.add(x.name);
            return l;
        }, (l, x)->{
            l.addAll(x);
            return l;
        }));*/
        LFUCache cache = new LFUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(5,5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }

    public class Person{
        String sex;
        String name;
    }
}
