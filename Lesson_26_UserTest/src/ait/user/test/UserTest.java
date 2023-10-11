package ait.user.test;

import ait.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    final String email = "peter@gmx.de";
    final String password = "12345Az!";

    @BeforeEach
    void setUp() {
        user = new User(email, password);
    }

    @Test
    void testValidPassword() {
        String validPassword = "qwertyA1$";
        user.setPassword(validPassword);
        assertEquals(validPassword, user.getPassword());
    }
    @Test
    void testPasswordLength(){
        String inValidPassword = "wertB7$";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }
    @Test
    void testPasswordUpperCase(){
        String inValidPassword = "wertb7$";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }
    @Test
    void testPasswordLowerCase(){
        String inValidPassword = "WQERTTT7$";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }
    @Test
    void testPasswordDIgit(){
        String inValidPassword = "WQWERTTTds$";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }
    @Test
    void testPasswordSpecialSymbol(){
        String inValidPassword = "WQWERsadTTT7";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }


}