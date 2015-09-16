package com.dta.services.model;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class PrivateMessage extends Message {

    private List<User> targets;


    // --------- constructors ----------

    public PrivateMessage() {
    }

    public PrivateMessage(Date creationDate, String content, User author, List<User> targets) {
        super(creationDate, content, author);
        this.targets = targets;
    }


    // -------- getter / setter --------

    public List<User> getTargets() {
        return targets;
    }

    public void setTargets(List<User> targets) {
        this.targets = targets;
    }

}
