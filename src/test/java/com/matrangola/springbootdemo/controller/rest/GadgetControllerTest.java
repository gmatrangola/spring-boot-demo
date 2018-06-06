package com.matrangola.springbootdemo.controller.rest;

import com.matrangola.springbootdemo.SpringBootDemoApplication;
import com.matrangola.springbootdemo.data.model.Gadget;
import com.matrangola.springbootdemo.data.model.User;
import com.matrangola.springbootdemo.data.repository.GadgetRepository;
import com.matrangola.springbootdemo.data.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemoApplication.class)
@WebAppConfiguration
public class GadgetControllerTest extends RestTest {

    @Autowired
    private GadgetRepository gadgetRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddGadget() throws Exception {
        Gadget gadget = new Gadget();
        gadget.setName("Test1");

        User user = new User("GadgetTestUser", "Last", new Date());
        userRepository.save(user);

        gadget.setOwner(user);

        mockMvc.perform(post("/gadget/add").contentType(JSON_CONTEXT_TYPE).content(json(gadget)));
    }

}