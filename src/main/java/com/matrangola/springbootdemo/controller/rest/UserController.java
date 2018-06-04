package com.matrangola.springbootdemo.controller.rest;

import com.matrangola.springbootdemo.data.model.User;
import com.matrangola.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping( value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    private static final SimpleDateFormat BIRTHDAY_TEXT_FORMAT = new SimpleDateFormat("YYYYMMdd");

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public User add(
            @RequestParam(value = "first")
            String firstName,
            @RequestParam(value = "last")
            String lastName,
            @RequestParam(required = false)
            String birthdayText) {

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        if (birthdayText != null) {
            try {
                user.setBirthday(BIRTHDAY_TEXT_FORMAT.parse(birthdayText));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        userService.addUser(user);
        return user;
    }

    @RequestMapping(value = "/new", method = RequestMethod.PUT)
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @RequestMapping(path = "/picture/{userId}", method = RequestMethod.PUT, consumes = {"image/jpeg"})
    public String picture(@PathVariable("userId")int userId, @RequestBody byte[] bytes) {
        String result =  "User ID: " + userId + " uploaded " + bytes.length + " bytes";
        return result;
    }
}
