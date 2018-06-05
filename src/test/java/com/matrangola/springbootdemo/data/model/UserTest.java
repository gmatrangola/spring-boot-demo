package com.matrangola.springbootdemo.data.model;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void setFirstName() {
        User fn = new User();
        fn.setFirstName("first");
        assertEquals("first", fn.getFirstName());
    }

    @Test
    public void lastName() {
        User ln = new User();
        ln.setLastName("last");
        assertEquals("last", ln.getFirstName());
    }

    @Test
    public void setBirthday() {
        Date date = new Date();
        User bd = new User();
        bd.setBirthday(date);
        assertEquals(date, bd.getBirthday());
    }

    @Test
    public void setEarlyBirthday() {
        Date early = makeDate(1990);
    }

    private Date makeDate(int year) {
        return null;
    }
}