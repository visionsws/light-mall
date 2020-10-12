package com.vicente.lightmall.test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class TimeTest {

    public static void main(String[] args) {
      timeToTimeStamp();
      localTimeTest3();
      new TimeTest().localDateTest1();

      new TimeTest().format1();
    }

    private static long timeToTimeStamp(){
        // 获得当前时间
        LocalDateTime localDateTime = LocalDateTime.now();
        // 将当前时间转为时间戳
        long second = localDateTime.toEpochSecond(ZoneOffset.ofHours(8));
        // 1580706475
        System.out.println(second);
        return second;
    }

    public static void localTimeTest3(){
        // 获得当前时间
        LocalDateTime localDateTime = LocalDateTime.now();
        // 将当前时间转为时间戳
        long milliseconds = localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
        // 1580707268
        System.out.println(milliseconds);

    }

    public void localTimeTest5(){
        //获得时间戳
        //long milliseconds = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long milliseconds = 1597852800000L;
        // 将时间戳转为当前时间
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(milliseconds/1000, 0, ZoneOffset.ofHours(8));
        // 2020-02-03T13:35:53
        System.out.println(localDateTime);

    }

    public void localDateTest1(){
        //获得时间戳
        //long milliseconds = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long milliseconds = 1597852800000L;
        // 将时间戳转为当前时间
        LocalDate localDate = Instant.ofEpochMilli(milliseconds).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        // 2020-02-03
        System.out.println(localDate);
    }

    public void format1(){
        // 获得 localDateTime
        long milliseconds = 1597852800000L;
        // 将时间戳转为当前时间
        LocalDate localDate = Instant.ofEpochMilli(milliseconds).atZone(ZoneOffset.ofHours(8)).toLocalDate();
        // 指定模式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // 将 LocalDateTime 格式化为字符串
        String format = localDate.format(dateTimeFormatter);
        // 2020/02/03 14/38/54
        System.out.println(format);
    }
}
