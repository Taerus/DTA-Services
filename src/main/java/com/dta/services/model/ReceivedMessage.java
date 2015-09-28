package com.dta.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ReceivedMessage {

    @Id @GeneratedValue
    private Long id;

    private User user;

    private Message message;

    @Column(name = "IS_READ")
    private boolean read;


    public ReceivedMessage() {

    }

    public ReceivedMessage(PrivateMessage message, User user) {
        this.message = message;
        this.user = user;
        this.read = false;
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

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

}
