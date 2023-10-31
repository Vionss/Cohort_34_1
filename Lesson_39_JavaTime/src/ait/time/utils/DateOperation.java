package ait.time.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;

public class DateOperation {
    public static void main(String[] args) {

        String s = "12/04/1961";
        System.out.println(getAge(s));

        String s3 = "1961-11-28";
        System.out.println(getAge(s3));

        DateTimeFormatter df = DateTimeFormatter.ISO_LOCAL_DATE;

        Comparator<String> dateComparator = (s1, s2) -> {
            if (s1 != null && s2 != null) {
                return s1.compareTo(s2);
            } else {
                return 0;
            }
        };


    }

    public static int getAge(String birthDate) {
        // TODO
        // parsing

//        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//        LocalDate date;
//        if(birthDate.contains("/")){
//            date = LocalDate.parse(birthDate,format1);
//        }else {
//            date = LocalDate.parse(birthDate,format2);
//        }
//        LocalDate localDate = LocalDate.now();
//        long years = ChronoUnit.YEARS.between(date,localDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy/MM/dd][yyyy-MM-dd][dd-MM-yyyy]");
        LocalDate date = LocalDate.parse(birthDate, formatter);
        LocalDate localDate = LocalDate.now();
        long years = ChronoUnit.YEARS.between(date, localDate);
        return (int) years;
    }

    public static String[] sortStringDates(String[] dates) {
        // TODO
        //скопіювати массив, сортувати масиив стрінг через компаратор(в локал дейт)

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy/MM/dd][yyyy-MM-dd][dd-MM-yyyy]");
        Comparator <String > dateComparator = (s1,s2) -> {
            LocalDate date1 = LocalDate.parse(s1,formatter);
            LocalDate date2 = LocalDate.parse(s2,formatter);
            return date1.compareTo(date2);
        };
        Arrays.sort(dates, dateComparator);
        return dates;
    }

}

