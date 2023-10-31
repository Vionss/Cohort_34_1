package ait.time.test;

import ait.time.utils.DateOperation;

import static org.junit.jupiter.api.Assertions.*;

class DateOperationTest {

    @org.junit.jupiter.api.Test
    void getAge() {
        assertEquals(62, DateOperation.getAge("12/04/1961"));
        assertEquals(61, DateOperation.getAge("1961-11-28"));

    }

    @org.junit.jupiter.api.Test
    void sortStringDates() {
        String [] dates = {"2000-12-01", "10/12/2000", "1970-08-12", "2010-10-05"};
        String [] actual = DateOperation.sortStringDates(dates);
        String [] expected = {"1970-08-12", "2000-12-01", "10/12/2000","2010-10-05"};
        assertArrayEquals(expected, actual);
    }
}