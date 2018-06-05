package com.matrangola.springbootdemo.controller.rest;

import com.matrangola.springbootdemo.data.model.Gadget;
import com.matrangola.springbootdemo.data.repository.GadgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( path = "/gadgets")
public class GadgetController {

    private final GadgetRepository gadgetRepository;

    @Autowired
    public GadgetController(GadgetRepository repository) {
        gadgetRepository = repository;
    }

    @RequestMapping(path = "add", method = RequestMethod.PUT)
    public Gadget add(@RequestBody Gadget gadget) {
        gadgetRepository.save(gadget);
        return gadget;
    }
}
