package ait.user;

import ait.user.model.User;

public class UserAppl {
    public static void main(String[] args) {
        User user = new User("peter@gmx.de", "1234");
//        System.out.println(user);
//        user.setEmail("-----------we@sbd.ee");
//        System.out.println(user);
//
        user.setPassword("weqq6rY%");
        System.out.println(user);


    }
}
