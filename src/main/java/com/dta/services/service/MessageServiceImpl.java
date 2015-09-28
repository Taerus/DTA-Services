package com.dta.services.service;

import com.dta.services.dao.IMessageDao;
import com.dta.services.dao.IReceivedMessageDao;
import com.dta.services.dao.ISentMessageDao;
import com.dta.services.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService {

    @Autowired
    IMessageDao messageDao;

    @Autowired
    ISentMessageDao sentMessageDao;

    @Autowired
    IReceivedMessageDao receivedMessageDao;

//    @Autowired
//    IAdvertMessageDao advertMessageDao;
//
//    @Autowired
//    IPrivateMessageDao privateMessageDao;


    // ---------------- Messages ----------------

    @Override
    public void postMessage(Message message) {
        messageDao.createMessage(message);

        if(message instanceof PrivateMessage) {
            SentMessage sm = new SentMessage((PrivateMessage) message);
            sentMessageDao.createSentMessage(sm);
            for (User target : ((PrivateMessage) message).getTargets()) {
                ReceivedMessage rm = new ReceivedMessage((PrivateMessage) message, target);
                receivedMessageDao.createReceivedMessage(rm);
            }
        }
    }

    @Override
    public void deleteMessage(long id) {
        messageDao.deleteMessage(id);
    }

    @Override
    public void deleteSentMessage(long id) {
        sentMessageDao.deleteSentMessage(id);
    }

    @Override
    public void deleteReceivedMessage(long id) {
        receivedMessageDao.deleteReceivedMessage(id);
    }


    // ------------ Private messages ------------

    @Override
    @Transactional(readOnly = true)
    public PrivateMessage getPrivateMessage(long id) {
        return messageDao.getPrivateMessageById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SentMessage> listSentPrivateMessages(long senderId) {
        return sentMessageDao.getSentMessagesByUserId(senderId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReceivedMessage> listReceivedPrivateMessages(long receiverId) {
        return receivedMessageDao.getReceivedMessagesByUserId(receiverId);
    }


    // ------------ Advert messages ------------

    @Override
    @Transactional(readOnly = true)
    public AdvertMessage getAdvertMessage(long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdvertMessage> listSentAdvertMessages(long senderId) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AdvertMessage> listReceivedAdvertMessages(long receiverId) {
        return null;
    }
    
}
