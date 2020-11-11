package com.davidhorstman.eeme.controllers;

import com.davidhorstman.eeme.models.Link;
import com.davidhorstman.eeme.services.LinkServices;
import com.davidhorstman.eeme.views.EncodedLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping(value = "/decode/{encoded}")
    public ResponseEntity<?> decodeLink(RedirectAttributes attributes, @PathVariable String encoded) {
        return new ResponseEntity<>(linkServices.findByEncodedId(encoded), HttpStatus.OK);

    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> newLink(@Valid @RequestBody Link link) {
        return new ResponseEntity<>(linkServices.save(link), HttpStatus.CREATED);
    }

    @PostMapping(value = "/encode", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> encodeLink(@Valid @RequestBody Link link) {
        link = linkServices.save(link);
        EncodedLink encoded = linkServices.encode(link);
        return new ResponseEntity<>(encoded, HttpStatus.CREATED);
    }
}
