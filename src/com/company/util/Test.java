package com.company.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime localDateTime = LocalDateTime.now( ZoneOffset.ofHours(8));;
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.now( ZoneOffset.ofHours(8));
        LocalDateTime localDateTime2 = localDateTime1.minusHours(1);
        System.out.println(localDateTime1);
        Duration duration = Duration.between(localDateTime, localDateTime1.minusHours(1));
        long hours = duration.toHours();
        System.out.println(hours);
    }
}
