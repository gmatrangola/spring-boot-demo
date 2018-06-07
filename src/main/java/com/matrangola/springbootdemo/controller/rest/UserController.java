package com.matrangola.springbootdemo.controller.rest;

import com.matrangola.springbootdemo.aop.Profiler;
import com.matrangola.springbootdemo.data.model.User;
import com.matrangola.springbootdemo.exception.ResourceException;
import com.matrangola.springbootdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping( value = "/users")
@Profiler
public class UserController extends Controller {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    private static final SimpleDateFormat BIRTHDAY_TEXT_FORMAT = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public User add(
            @RequestParam(value = "first")
            String firstName,
            @RequestParam(value = "last")
            String lastName,
            @RequestParam(value = "birthday", required = false)
            String birthdayText) {
        LOG.debug("add");
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        if (birthdayText != null) {
            try {
                Date date = BIRTHDAY_TEXT_FORMAT.parse(birthdayText);
                user.setBirthday(date);
            } catch (ParseException e) {
                LOG.error("Could not parse {}", birthdayText, e);
            }
        }

        userService.addUser(user);
        return user;
    }

    @RequestMapping(value = "/new", method = RequestMethod.PUT)
    public User addUser(@RequestBody User user) {
        LOG.debug("add");
        userService.addUser(user);
        return user;
    }

    @RequestMapping(path = "/picture/{userId}", method = RequestMethod.PUT, consumes = {"image/jpeg"})
    public String picture(@PathVariable("userId")int userId, @RequestBody byte[] bytes) {
        LOG.debug("picture");
        String result =  "User ID: " + userId + " uploaded " + bytes.length + " bytes";
        return result;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") long id) throws ResourceException {
        LOG.debug("getUser {}", id);
        User user = userService.getUser(id);
        LOG.debug("got user {}", user);
        return user;
    }
}
