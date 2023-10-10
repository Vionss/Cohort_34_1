package homework_24;

public class MinMaxValues {
    public static void main(String[] args) {
            /*
Написать приложение для печати минимальных/максимальных значений заданных примитивных типов.
Типы как объекты String следует брать из аргументов метода main.
Если в аргументах нет никакого типа, приложение должно вывести максимальный/минимальный значения 7 типов
 (byte, int, short, long, char, float, double).
Если аргументы содержат неправильный тип, приложение должно вывести сообщение: Wrong type
             */

       minMaxValues(args);

    }

    public static void  minMaxValues(String[] str) {

        if (str.length == 0) {
            System.out.println("Byte: " + Byte.MIN_VALUE + " / " + Byte.MAX_VALUE + "; " + "Integer: " + Integer.MIN_VALUE + " / " + Integer.MAX_VALUE + "; " +
                    "Short : " + Short.MIN_VALUE + " / " + Short.MAX_VALUE + "; " + "Long: " + Long.MIN_VALUE + " / " + Long.MAX_VALUE + "; " +
                    "Character: " + (int) Character.MIN_VALUE + " / " + (int) Character.MAX_VALUE + "; " + "Float: " + Float.MIN_VALUE + " / " + Float.MAX_VALUE + "; " +
                    "Double: " + Double.MIN_VALUE + " / " + Double.MAX_VALUE + "; ");
        }

        for (int i = 0; i < str.length; i++) {

            switch (str[i]) {
                case "byte":
                    System.out.println("Byte: " + Byte.MIN_VALUE + " / " + Byte.MAX_VALUE + "; ");
                    break;
                case "int":
                    System.out.println("Integer: " + Integer.MIN_VALUE + " / " + Integer.MAX_VALUE + "; ");
                    break;
                case "short":
                    System.out.println("Short: " + Short.MIN_VALUE + " / " + Short.MAX_VALUE + "; ");
                    break;
                case "long":
                    System.out.println("Long: " + Long.MIN_VALUE + " / " + Long.MAX_VALUE + " ;");
                    break;
                case "char":
                    System.out.println("Character: " + (int) Character.MIN_VALUE + " / " + (int) Character.MAX_VALUE + "; ");
                    break;
                case "float":
                    System.out.println("Float: " + Float.MIN_VALUE + " / " + Float.MAX_VALUE + "; ");
                    break;
                case "double":
                    System.out.println("Double: " + Double.MIN_VALUE + " / " + Double.MAX_VALUE + "; ");
                    break;
                default:
                    System.out.println("Wrong Type");
                    break;
            }
        }
    }
}