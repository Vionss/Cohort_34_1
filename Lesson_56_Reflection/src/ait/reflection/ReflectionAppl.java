package ait.reflection;

public class ReflectionAppl {
    public static void main(String[] args) {
        Class<String> clazzStr1 = String.class;
        String str = "hello";
        Class<? extends String> clazzStr2 = str.getClass();
    }
}
