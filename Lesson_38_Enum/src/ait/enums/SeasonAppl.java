package ait.enums;

import ait.enums.model.Season;

public class SeasonAppl {
    public static void main(String[] args) {
        Season season = Season.AUTUMN;
        System.out.println(season);
        System.out.println(Season.SUMMER);
        System.out.println(season.name());
        season = Season.valueOf("SPRING");
        System.out.println(season);
        System.out.println("====== values =====");
        Season[] seasons = Season.values();
        for (int i = 0; i < seasons.length; i++) {
            System.out.println(seasons[i]);
        }

        System.out.println("=== ordinal ===");
        System.out.println(season.name());
        System.out.println(season.ordinal());
        System.out.println(Season.AUTUMN.ordinal());
    }
}
