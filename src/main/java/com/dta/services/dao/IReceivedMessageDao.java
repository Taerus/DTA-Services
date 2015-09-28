package com.dta.services.dao;

import com.dta.services.model.ReceivedMessage;

import java.util.List;

public interface IReceivedMessageDao {

    void createReceivedMessage(ReceivedMessage receivedMessage);
    ReceivedMessage getReceivedMessageById(long id);
    List<ReceivedMessage> getReceivedMessagesByUserId(long userId);
    void updateReceivedMessage(ReceivedMessage receivedMessage);
    void deleteReceivedMessage(long id);

}
