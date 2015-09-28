package com.dta.services.dao;

import com.dta.services.model.ReceivedMessage;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReceivedMessageDaoImpl implements IReceivedMessageDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public void createReceivedMessage(ReceivedMessage receivedMessage) {
        em.persist(receivedMessage);
    }

    @Override
    public ReceivedMessage getReceivedMessageById(long id) {
        return em.find(ReceivedMessage.class, id);
    }

    @Override
    public List<ReceivedMessage> getReceivedMessagesByUserId(long userId) {
        TypedQuery<ReceivedMessage> query = em.createQuery(
                "SELECT msg " +
                        "FROM ReceivedMessage msg " +
                        "JOIN msg.user u " +
                        "WHERE u.id = :user_id",
                ReceivedMessage.class
        );

        query.setParameter("user_id", userId);

        return query.getResultList();
    }

    @Override
    public void updateReceivedMessage(ReceivedMessage receivedMessage) {
        em.merge(receivedMessage);
    }

    @Override
    public void deleteReceivedMessage(long id) {
        em.remove(em.find(ReceivedMessage.class, id));
    }

}
