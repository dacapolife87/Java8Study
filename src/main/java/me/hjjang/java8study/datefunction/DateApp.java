package me.hjjang.java8study.datefunction;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateApp {

    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);

        Thread.sleep(1000 * 3);
        Date after3Seconds = new Date();
        System.out.println(after3Seconds);

        after3Seconds.setTime(time);  //  mutable 하다 상태가 바뀔수가있다. 멀티쓰레드 환경에서 안전하지않다 thread safety 가 보장이안된다
        System.out.println(after3Seconds);

        // Calendar에서는 월이 0부터 시작한다. 그래서 인텔리제이에서 enum으로 받도록 알린다. type safety가 보장이안된다.
        Calendar hjjangBirthDay1 = new GregorianCalendar(1987, 11, 11);
        Calendar hjjangBirthDay2 = new GregorianCalendar(1987, Calendar.NOVEMBER, 11);
        System.out.println(hjjangBirthDay1.getTime());
        hjjangBirthDay1.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println(hjjangBirthDay1.getTime());


    }
}
