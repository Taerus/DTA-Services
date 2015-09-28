package com.dta.services.service;


import com.dta.services.model.*;

import java.util.List;

public interface IMessageService {

    void postMessage(Message message);
    void deleteMessage(long id);
    void deleteSentMessage(long id);
    void deleteReceivedMessage(long id);

    PrivateMessage getPrivateMessage(long id);
    List<SentMessage> listSentPrivateMessages(long senderId);
    List<ReceivedMessage> listReceivedPrivateMessages(long receiverId);

    AdvertMessage getAdvertMessage(long id);
    List<AdvertMessage> listSentAdvertMessages(long senderId);
    List<AdvertMessage> listReceivedAdvertMessages(long receiverId);
}
