package ait.stringbyilder;

public class StringBuilderAppl {
    public static void main(String[] args) {
        String str = "popec";
//        str = str + 11;
//        System.out.println(str);
//        StringBuilder builder = new StringBuilder("Java");
//        builder.append(11);
//        System.out.println(builder);
//        str = arrayConcatAvanced(new String[]{"one", "two", "three", "four", "five"});
//        System.out.println(str);
       stringReverse(str);

    }

    public static String arrayConcat(String[] arr) {
        String res = "";
        for (int i = 0; i < arr.length - 1; i++) {
            res = res + arr[i] + "->";
        }
        res = res + arr[arr.length - 1];
        return res;
    }

    public static String arrayConcatAvanced(String[] arr) {
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < arr.length - 1; i++) {
            res.append(arr[i]).append("->");
        }
        res.append(arr[arr.length - 1]);
        return res.toString();
    }

    public static String stringReverse(String str) {
        StringBuilder res = new StringBuilder();
        for (int i = str.length() -1; i >=0; i--) {
           res.append(str.charAt(i));
            System.out.println(str.charAt(i));
        }
        return res.toString();
    }
}
