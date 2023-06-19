package com.solthoth.emailservice;

import com.solthoth.emailservice.controllers.EmailController;
import com.solthoth.emailservice.models.Email;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class EmailModelAssembler implements RepresentationModelAssembler<Email, EntityModel<Email>> {

    @Override
    public EntityModel<Email> toModel(Email email) {
        return EntityModel.of(email,
                linkTo(methodOn(EmailController.class).getEmailStatus(email.getPublicId().toString())).withSelfRel(),
                linkTo(methodOn(EmailController.class).getAvailableEmailStatus()).withRel("emails"));
    }
}
