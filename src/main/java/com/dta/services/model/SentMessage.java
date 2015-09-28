package com.dta.services.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SentMessage {

    @Id @GeneratedValue
    private Long id;

    private User user;

    private Message message;


    public SentMessage() {

    }

    public SentMessage(PrivateMessage message) {
        this.message = message;
        this.user = message.getAuthor();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

}
