package com.dta.services.dao;

import java.util.List;

import com.dta.services.model.Message;
import com.dta.services.model.PrivateMessage;

public interface IMessageDao {

	void createMessage(Message message);
	Message getMessageById(long id);
	List<Message> listMessages();
	void updateMessage(Message message);
	void deleteMessage(long id);

	PrivateMessage getPrivateMessageById(long id);
	List<PrivateMessage> getPrivateMessagesByAuthor(long authorId);
	List<PrivateMessage> listPrivateMessages();
	
}
