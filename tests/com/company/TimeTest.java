package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
    @Test
    public void testHoursToString() {
        Time time = new Time(100, Time.Measure.h);
        assertEquals("100.0 ч.", time.toString());
    }

    @Test
    public void testDaysToString() {
        Time time = new Time(100, Time.Measure.day);
        assertEquals("100.0 д.", time.toString());
    }

    @Test
    public void testWeeksToString() {
        Time time = new Time(100, Time.Measure.week);
        assertEquals("100.0 нед.", time.toString());
    }

    @Test
    public void testMontsString() {
        Time time = new Time(100, Time.Measure.month);
        assertEquals("100.0 мес.", time.toString());
    }

    @Test
    public void testAddNumber() {
        Time time = new Time(100, Time.Measure.h);
        time = time.add(5);
        assertEquals("105.0 ч.", time.toString());
    }

    @Test
    public void testSubtractNumber() {
        Time time = new Time(100, Time.Measure.h);
        time = time.subtract(5);
        assertEquals("95.0 ч.", time.toString());
    }

    @Test
    public void testMultiplyByNumber() {
        Time time = new Time(100, Time.Measure.h);
        time = time.multiply(5);
        assertEquals("500.0 ч.", time.toString());
    }

    @Test
    public void testDivideByNumber() {
        Time time = new Time(100, Time.Measure.h);
        time = time.divide(5);
        assertEquals("20.0 ч.", time.toString());
    }

    @Test
    public void testCompareWithNumber() {
        Time time1 = new Time(100, Time.Measure.h);
        Time time2 = new Time(150, Time.Measure.day);
        assertEquals(true, time1.compare(time2));
    }

    @Test
    public void testConvertInDate() {
        Time time = new Time(100, Time.Measure.h);
        assertEquals("5 января", time.convertInDate(time));
    }

    @Test
    public void testConvertInDate2() {
        Time time = new Time(0, Time.Measure.day);
        assertEquals("1 января", time.convertInDate(time));
    }

    @Test
    public void testConvertInDate3() {
        Time time = new Time(400, Time.Measure.day);
        assertEquals("11 февраля", time.convertInDate(time));
    }

    @Test
    public void testConvertInDate4() {
        Time time = new Time(90, Time.Measure.day);
        assertEquals("1 апреля", time.convertInDate(time));
    }

    @Test
    public void testConvertHourToAny() {
        Time time;

        time = new Time(24, Time.Measure.h);
        assertEquals("1.0 д.", time.to(Time.Measure.day).toString());

        time = new Time(168, Time.Measure.h);
        assertEquals("1.0 нед.", time.to(Time.Measure.week).toString());
    }

    @Test
    public void testConvertAnyToHour() {
        Time time;

        time = new Time(1, Time.Measure.week);
        assertEquals("168.0 ч.", time.to(Time.Measure.h).toString());

        time = new Time(1, Time.Measure.month);
        assertEquals("720.0 ч.", time.to(Time.Measure.h).toString());
    }

    @Test
    public void testAddTwoTimes() {
        Time time1 = new Time(24, Time.Measure.h);
        Time time2 = new Time(2, Time.Measure.day);

        assertEquals(time1.add(time2), new Time(72, Time.Measure.h));
        assertEquals(time1.add(time2), new Time(3, Time.Measure.day));
    }

    @Test
    public void testSubtractTwoTimes() {
        Time length1 = new Time(1, Time.Measure.day);
        Time length2 = new Time(1, Time.Measure.h);

        assertEquals(length1.subtract(length2), new Time(23, Time.Measure.h));
        assertEquals(length1.subtract(length2), new Time(0.9583333333333334, Time.Measure.day));
    }
}