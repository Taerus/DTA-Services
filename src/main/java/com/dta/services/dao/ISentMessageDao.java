package com.dta.services.dao;

import com.dta.services.model.SentMessage;
import com.dta.services.model.User;

import java.util.List;

public interface ISentMessageDao {

    void createSentMessage(SentMessage sentMessage);
    SentMessage getSentMessageById(long id);
    List<SentMessage> getSentMessagesByUserId(long userId);
    void updateSentMessage(SentMessage sentMessage);
    void deleteSentMessage(long id);

}
