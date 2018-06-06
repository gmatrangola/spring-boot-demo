package com.matrangola.springbootdemo.controller.rest;

import com.matrangola.springbootdemo.SpringBootDemoApplication;
import com.matrangola.springbootdemo.data.model.User;
import com.matrangola.springbootdemo.data.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
@WebAppConfiguration
public class UserControllerTest extends RestTest {

    @Autowired
    private UserRepository userRepository;

    private User user1;
    private User user2;
    private String jsonUser1;

    public void setup() throws IOException {
        super.setup();
        Calendar calendar = Calendar.getInstance();
        calendar.set(1990, 06, 28, 01, 00, 00);
        calendar.setTimeZone(TimeZone.getDefault());
        Date birthday = new Date(calendar.getTimeInMillis());
        user1 = userRepository.save(new User("First1", "last1", birthday));
        user2 = userRepository.save(new User("First2", "Last2", birthday));
        jsonUser1 = json(user1);
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void addUser() {
    }

    @Test
    public void getUser() throws Exception {
        mockMvc.perform(get("/users/" + user1.getId()).contentType(JSON_CONTEXT_TYPE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(JSON_CONTEXT_TYPE))
                .andExpect(content().json(jsonUser1));
    }

}