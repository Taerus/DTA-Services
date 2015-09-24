package com.dta.services.utils;


import java.util.List;

public class MessageForm {

    private List<Long> targets;
    private String subject;
    private String content;

    public List<Long> getTargets() {
        return targets;
    }

    public void setTargets(List<Long> targets) {
        this.targets = targets;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
