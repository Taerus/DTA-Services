package com.dta.services.model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class AdvertMessage extends Message {

    private Advert advert;

    public AdvertMessage() {
    }


    // --------- constructors ----------

    public AdvertMessage(Date creationDate, String content, User author, Advert advert) {
        super(creationDate, content, author);
        this.advert = advert;
    }


    // -------- getter / setter --------

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }

}
