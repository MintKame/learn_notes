package _4_tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;

public class _2_date {
    public static void main(String[] args) {

        System.currentTimeMillis();//当前距离1970-1-1的ms数

        //! 三代Date
        // 1 (jdk1.0
        Date date0 = new Date(); // 当前时间，精确到ms
        Date date1 = new Date(1);

        System.out.println(date1); // 以国外格式打印

        // 格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // date -> str
        String str1 = sdf.format(date0);
        System.out.println(str1);
        // str -> date
        try {
            Date date2 = sdf.parse("2021-05-26 00:00");
            System.out.println(date2.toString()); // Wed May 26 00:00:00 CST 2021
        } catch (ParseException e) { // must: parse str same as pattern
            e.printStackTrace();
        }

        //! 2 (jdk1.1
        System.out.println("Calendar===========================");
        Calendar calendar = Calendar.getInstance(); // Calender is abs cls
        calendar.set(Calendar.DATE, 1);
        // -> str (格式化输出
        System.out.format("%4d-%02d-%02d %02d:%02d\n",
                calendar.get(Calendar.YEAR), 1 + calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE),
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
        // 注意：month+1， hour为24/12进制

        // problems of 1, 2:
        //      日期可变，不需要
        //      偏移：date从1900开始，calendar.get(Calendar.MONTH) 从 0 开始（表示1月）
        //      calendar没有格式化
        //      不是线程安全

        //! 3 (
        System.out.println("===========================");
        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.of(ld, lt);
        ldt = LocalDateTime.of(2001, 5, 26, 0, 0, 0);

        System.out.println(ldt); // 2001-05-26T00:00
        System.out.println(ldt.getMonth()); // MAY
        System.out.println(ldt.getMonthValue()); // 5

        // 格式化
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        // ldt -> str
        str1 = dtf.format(ldt);
        System.out.println(str1);
        // str -> ldt
        TemporalAccessor parse = dtf.parse("2000-01-01 00:00:00");// todo

        //! Instant 时间戳 类似于 Date
        Instant instant = Instant.now();
        // instant = Instant.from(parse);
        System.out.println(instant);

        // instant -> date
        Date date2 = Date.from(instant);
        // date -> instant
        instant = date2.toInstant();

        // 其他方法：
        // MonthDay类检查重复事件
        // 是否闰年
        // plus minus 方法： 增减日期的某个部分


    }
}