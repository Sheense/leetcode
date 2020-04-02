package com.company.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        List<Person> list = new ArrayList<>();
        list.stream().collect(Collectors.toMap(x -> x.sex, x->{
            List<String> l = new ArrayList<>();
            l.add(x.name);
            return l;
        }, (l, x)->{
            l.addAll(x);
            return l;
        }));


    }

    public class Person{
        String sex;
        String name;
    }
}
