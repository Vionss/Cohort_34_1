package ait.mystring;

import ait.mystring.model.MyString;

import java.util.Iterator;

public class MyStringAppl {
    public static void main(String[] args) {
        MyString myStr = new MyString("Two beer, or not two beer");
        System.out.println(myStr);
        myStr.addChar('!');
        System.out.println(myStr);
        myStr.removeChar(',');
        System.out.println(myStr);
        System.out.println("===================================");
        Iterator<Character> iterator = myStr.iterator();
        while (iterator.hasNext()) {
            char c = iterator.next();
            if(c == 'e'){
                iterator.remove();
            }
        }
        System.out.println(myStr);
//        System.out.println("===================================");
//        iterator = myStr.iterator();
//        while (iterator.hasNext()) {
//            char c = iterator.next();
//            System.out.println(Character.toLowerCase(c));
//        }


//        WRONG WAY!!!!
//
//        for (char c : myStr) {
//            if(c == 'r'){
//                myStr.removeChar(c);
//            }
//        }
//        System.out.println(myStr);
//

//        for (char c:myStr) {
//            System.out.println(Character.toUpperCase(c));
//        }


//        StringBuilder builder = myStr.getStr();
//        for (int i = 0; i < builder.length(); i++) {
//            System.out.println(Character.toUpperCase(builder.charAt(i)));
//        }
//        builder.setLength(3);
//        System.out.println(builder);
//        System.out.println(myStr);
    }
}
