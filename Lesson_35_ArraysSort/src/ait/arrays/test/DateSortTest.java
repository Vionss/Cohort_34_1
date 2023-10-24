package ait.arrays.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DateSortTest {
    Comparator<String> comparator;

    @BeforeEach
    void setUp() {
        comparator = (s1, s2) -> {
            String[] splited1 = s1.split("-");
            String[] splited2 = s2.split("-");
            int day1 = Integer.parseInt(splited1[0]);
            int month1 = Integer.parseInt(splited1[1]);
            int year1 = Integer.parseInt(splited1[2]);

            int day2 = Integer.parseInt(splited2[0]);
            int month2 = Integer.parseInt(splited2[1]);
            int year2 = Integer.parseInt(splited2[2]);

            if (year1 > year2) {
                return 1;
            } else if (year1 < year2) {
                return -1;
            }
            if (month1 > month2) {
                return 1;
            } else if (month1 < month2) {
                return -1;
            }
            if (day1 > day2) {
                return 1;
            } else if (day1 < day2) {
                return -1;
            }
            return 0;
        };
    }
        @Test
        void testDateSort () {
            String[] dates = {
                    "07-05-1990",
                    "28-01-2010",
                    "11-08-1990",
                    "15-01-2010",
                    "16-06-1970"
            };
            String[] expected = {
                    "16-06-1970",
                    "07-05-1990",
                    "11-08-1990",
                    "15-01-2010",
                    "28-01-2010"
            };
            Arrays.sort(dates, comparator);
            assertArrayEquals(expected, dates);
        }
    }
