package me.innjoy.pms.test;

import org.junit.Test;

/**
 *
 */
public class TestTime {
    @Test
    public void name() throws Exception {
        long validTime = 1521791464000L;
        System.out.println(validTime);
        long now = System.currentTimeMillis();
        System.out.println(now);
        long l = now - validTime;
        System.out.println(l);
        System.out.println(24 * 60 * 60 * 1000L);
        long day = l / (24 * 60 * 60 * 1000L);

        long hour = (l / (60 * 60 * 1000L) - day * 24);

        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        System.out.println(day);
        System.out.println(hour);
        System.out.println(min);
    }
}
