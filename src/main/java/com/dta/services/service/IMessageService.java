package com.dta.services.service;


import com.dta.services.model.AdvertMessage;
import com.dta.services.model.Message;
import com.dta.services.model.PrivateMessage;

import java.util.List;

public interface IMessageService {

    public void postMessage(Message message);
    public void deleteMessage(long id);

    public PrivateMessage getPrivateMessage(long id);
    public List<PrivateMessage> listSentPrivateMessages(long senderId);
    public List<PrivateMessage> listReceivedPrivateMessages(long receiverId);

    public AdvertMessage getAdvertMessage(long id);
    public List<AdvertMessage> listSentAdvertMessages(long senderId);
    public List<AdvertMessage> listReceivedAdvertMessages(long receiverId);

}
