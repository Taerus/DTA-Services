package com.dta.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.dta.services.model.PrivateMessage;
import org.springframework.stereotype.Repository;

import com.dta.services.model.Message;

@Repository("messageDao")
public class MessageDaoImpl implements IMessageDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public void createMessage(Message message) {
		em.persist(message);
	}

	@Override
	public Message getMessageById(long id) {
		return em.find(Message.class, id);
	}

	@Override
	public List<Message> listMessages() {
		return em.createQuery("SELECT m FROM Message m", Message.class).getResultList();
	}

	@Override
	public void updateMessage(Message message) {
		em.merge(message);
	}

	@Override
	public void deleteMessage(long id) {
		em.remove(em.find(Message.class, id));
	}


	// ------------ Private Messages ------------

	@Override
	public PrivateMessage getPrivateMessageById(long id) {
		return em.find(PrivateMessage.class, id);
	}

	@Override
	public List<PrivateMessage> getPrivateMessagesByAuthor(long authorId) {
		TypedQuery<PrivateMessage> query = em.createQuery(
				"SELECT msg " +
						"FROM PrivateMessage msg " +
						"WHERE msg.author.id = :author_id",
				PrivateMessage.class
		);

		query.setParameter("author_id", authorId);

		return query.getResultList();
	}

	@Override
	public List<PrivateMessage> listPrivateMessages() {
		TypedQuery<PrivateMessage> query = em.createQuery(
				"SELECT msg FROM PrivateMessage msg",
				PrivateMessage.class
		);

		return query.getResultList();
	}
}
