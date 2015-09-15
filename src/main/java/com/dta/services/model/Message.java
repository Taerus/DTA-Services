package com.dta.services.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Message {

    @Id @GeneratedValue
    private long id;

    private Date creationDate;

    private String content;

    private User author;


    // --------- constructors ----------

    public Message() {
    }

    public Message(Date creationDate, String content, User author) {
        this.creationDate = creationDate;
        this.content = content;
        this.author = author;
    }

    // -------- getter / setter --------

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

}
