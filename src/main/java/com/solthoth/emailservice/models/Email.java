package com.solthoth.emailservice.models;

//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import org.springframework.lang.NonNullApi;

import java.util.Objects;
import java.util.UUID;

//@Entity
public class Email {
    private /*@Id @GeneratedValue */Long id;
    private /*@GeneratedValue(strategy = GenerationType.UUID) */UUID publicId;
    private String sender;
    private String recipient;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getPublicId() {
        return publicId;
    }

    public void setPublicId(UUID publicId) {
        this.publicId = publicId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(id, email.id) && Objects.equals(sender, email.sender) && Objects.equals(recipient, email.recipient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sender, recipient);
    }
}
