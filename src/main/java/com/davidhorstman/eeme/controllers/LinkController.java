package com.davidhorstman.eeme.controllers;

import com.davidhorstman.eeme.models.Link;
import com.davidhorstman.eeme.services.LinkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/links")
public class LinkController {
    @Autowired
    LinkServices linkServices;

    @GetMapping(value = "/all", produces = "application/json")
    public ResponseEntity<?> getAllLinks() {
        return new ResponseEntity<>(linkServices.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<?> getLinkById(@PathVariable long id) {
        return new ResponseEntity<>(linkServices.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> newLink(@Valid @RequestBody Link link) {
        return new ResponseEntity<>(linkServices.save(link), HttpStatus.CREATED);
    }
}