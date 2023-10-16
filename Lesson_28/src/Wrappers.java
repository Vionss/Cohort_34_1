public class Wrappers {
    public static void main(String[] args) {

    }
    public static String getDigits(String source) { // вернуть из входящей строки только числа от 0 до 9.
        String res = "";
        for (int i = 0; i < source.length(); i++) {
            char currentChar = source.charAt(i);
            if (currentChar >= '0' && currentChar <= '9') { // 0 1 2 3 ... 9
//                res += currentChar;
                res = res + currentChar;
            }
        }
        return res;
    }

}
