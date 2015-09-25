package com.dta.services.service;

import com.dta.services.dao.IMessageDao;
import com.dta.services.model.AdvertMessage;
import com.dta.services.model.Message;
import com.dta.services.model.PrivateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService {

    @Autowired
    IMessageDao messageDao;

//    @Autowired
//    IAdvertMessageDao advertMessageDao;
//
//    @Autowired
//    IPrivateMessageDao privateMessageDao;


    // ---------------- Messages ----------------

    @Override
    public void postMessage(Message message) {
        messageDao.createMessage(message);
    }

    @Override
    public void deleteMessage(long id) {
        messageDao.deleteMessage(id);
    }


    // ------------ Private messages ------------

    @Override
    @Transactional(readOnly = true)
    public PrivateMessage getPrivateMessage(long id) {
        return messageDao.getPrivateMessageById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PrivateMessage> listSentPrivateMessages(long senderId) {
        return messageDao.getPrivateMessagesByAuthor(senderId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PrivateMessage> listReceivedPrivateMessages(long receiverId) {
        return messageDao.getPrivateMessagesByTarget(receiverId);
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
