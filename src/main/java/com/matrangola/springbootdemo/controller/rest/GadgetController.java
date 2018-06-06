package com.matrangola.springbootdemo.controller.rest;

import com.matrangola.springbootdemo.data.model.Gadget;
import com.matrangola.springbootdemo.data.repository.GadgetRepository;
import com.matrangola.springbootdemo.exception.ResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Gadget getGadget(@PathVariable("id") long id) throws ResourceException {
        Optional<Gadget> gadget = gadgetRepository.findById(id);
        if (!gadget.isPresent()) throw new ResourceException(Gadget.class, id);
        return gadget.get();
    }
}
