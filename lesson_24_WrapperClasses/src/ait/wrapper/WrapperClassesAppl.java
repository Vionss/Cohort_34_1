package ait.wrapper;

public class WrapperClassesAppl {
    public static void main(String[] args) {

        int a = 42;
        Integer b = 20;
        System.out.println(a);
        System.out.println(b);
        b = b - a;
        System.out.println(b);

        String strB = b.toString();
        System.out.println(strB instanceof String);
        //String strA = a + "";
        String strA = Integer.toString(a + b);
        System.out.println(strA);
        strA = "125.2";
        double c = Double.parseDouble(strA);
        System.out.println(c);
        c = c - 10;
        System.out.println(c);
        strB = "3.1415926";
        double pi = Double.parseDouble(strB);
        System.out.println(pi);

        double circleLenght = 2 * pi * 10;
        System.out.println(circleLenght);

        strB = "true";
        boolean check = Boolean.parseBoolean(strB);
        System.out.println(check);
        double res = 0. / 0;
        if(Double.isInfinite(res) || Double.isNaN(res)){
            System.out.println("Wrong result");
        }else {
            System.out.println(res);
        }

    }
}
