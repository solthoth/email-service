package com.solthoth.emailservice.controllers;

import com.solthoth.emailservice.EmailModelAssembler;
import com.solthoth.emailservice.models.Email;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("emails")
public class EmailController {

    private final EmailModelAssembler assembler;
    public EmailController(EmailModelAssembler assembler) {
        this.assembler = assembler;
    }

    @GetMapping("")
    public CollectionModel<EntityModel<Email>> getAvailableEmailStatus() {
        var emails = new ArrayList<Email>().stream().map(assembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(emails, linkTo(methodOn(EmailController.class).getAvailableEmailStatus()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Email> getEmailStatus(@PathVariable String id) {
        var email = new Email();
        email.setId(new Random().nextLong());
        email.setPublicId(UUID.randomUUID());
        return assembler.toModel(email);
    }
}
