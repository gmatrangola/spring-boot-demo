package com.matrangola.springbootdemo.controller.rest;

import com.matrangola.springbootdemo.SpringBootDemoApplication;
import com.matrangola.springbootdemo.data.model.User;
import com.matrangola.springbootdemo.data.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
@WebAppConfiguration
public class UserControllerTest extends RestTest {

    @Autowired
    private UserRepository userRepository;

    private User user1;
    private User user2;
    private String jsonUser1;

    @Before
    public void setup() throws IOException {
        mockMvc = webAppContextSetup(webApplicationContext).build();

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
        mockMvc.perform(get("/users/1").contentType(JSON_CONTEXT_TYPE))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonUser1));
    }

}