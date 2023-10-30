package ait.enums.model;

public enum Month {
    JAN(31),FEB(28),MAR(31),APR(30),MAY(31),JUN(30),JUL(31),
    AUG(31),SEP(30),OCT(31),NOV(30),DEC(31);
    private int days;

    Month(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public Month plusMonth(int quantity){
        Month[] values = Month.values();
        int index = ordinal();
        index = index + quantity;
        return values[index % values.length];
    }

    public static String getName(int position){
        Month[] values = values();
        return values[(position - 1) % values.length].name();
    }
}
