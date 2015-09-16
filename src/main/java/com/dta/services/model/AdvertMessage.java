package com.dta.services.model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class AdvertMessage extends Message {

    private String title;

    public AdvertMessage() {
    }


    // --------- constructors ----------

    public AdvertMessage(Date creationDate, String content, User author, String title) {
        super(creationDate, content, author);
        this.title = title;
    }


    // -------- getter / setter --------

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
