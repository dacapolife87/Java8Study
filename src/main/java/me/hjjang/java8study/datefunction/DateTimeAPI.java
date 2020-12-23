package me.hjjang.java8study.datefunction;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTimeAPI {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC"))); // 기준시 UTC, GMT
        ZoneId zone = ZoneId.systemDefault();
        System.out.println(zone);
        ZonedDateTime zonedDateTime = instant.atZone(zone);
        System.out.println(zonedDateTime);

        ZonedDateTime zonedDateTime1 = instant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);
        System.out.println("-----------------------------------");
        // 해당 장비의 지역정보를 가지고 시간을 표기한다. 서버가 해외에 있을경우 해외의 시간으로 표시가됨
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime birthDay =
                LocalDateTime.of(1987, 11, 11, 0, 0, 0);

        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKorea);

        LocalDate today = LocalDate.now();
        LocalDate thisYeaBirthday = LocalDate.of(2021, 11,11);

        System.out.println("---------------------------------------");
        Period between = Period.between(today, thisYeaBirthday);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());


        Period until = today.until(thisYeaBirthday);
        System.out.println(until.get(ChronoUnit.DAYS));

        // Period는 휴먼용 시간이라면 Duration은 기계용 시간을 비교
        Instant nowInstant = Instant.now();
        Instant plus = nowInstant.plus(10, ChronoUnit.SECONDS);
        Duration between1 = Duration.between(nowInstant, plus);
        System.out.println(between1.getSeconds());

        System.out.println("---------------------------------------");

        LocalDateTime now1 = LocalDateTime.now();
        DateTimeFormatter mmddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        System.out.println(now1.format(mmddyyyy));

        LocalDate parse = LocalDate.parse("11/11/1987", mmddyyyy);
        System.out.println(parse);

        Date date = new Date();
        Instant instant1 = date.toInstant();
        Date newDate = Date.from(instant1);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        LocalDateTime localDateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        GregorianCalendar from = GregorianCalendar.from(ZonedDateTime.now());

        ZoneId zoneId = TimeZone.getTimeZone("PST").toZoneId();
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);

    }
}
