package com.matrangola.springbootdemo.data.model;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class UserTestObject {

    private User user;
    private Date birthday;

    @Before
    public void setup() {
        user = new User();
        user.setFirstName("first");
        user.setLastName("last");
        birthday = new Date();
        user.setBirthday(birthday);
    }

    @Test
    public void getFirstName() {
        assertEquals("first", user.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("last", user.getLastName());
    }

    @Test
    public void getBirthday() {
        assertEquals(birthday, user.getBirthday());
    }
}