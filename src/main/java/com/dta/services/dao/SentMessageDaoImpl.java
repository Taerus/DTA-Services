package com.dta.services.dao;

import com.dta.services.model.SentMessage;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SentMessageDaoImpl implements ISentMessageDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public void createSentMessage(SentMessage sentMessage) {
        em.persist(sentMessage);
    }

    @Override
    public SentMessage getSentMessageById(long id) {
        return em.find(SentMessage.class, id);
    }

    @Override
    public List<SentMessage> getSentMessagesByUserId(long userId) {
        TypedQuery<SentMessage> query = em.createQuery(
                "SELECT msg " +
                        "FROM SentMessage msg " +
                        "JOIN msg.user u " +
                        "WHERE u.id = :user_id",
                SentMessage.class
        );

        query.setParameter("user_id", userId);

        return query.getResultList();
    }

    @Override
    public void updateSentMessage(SentMessage sentMessage) {
        em.merge(sentMessage);
    }

    @Override
    public void deleteSentMessage(long id) {
        em.remove(em.find(SentMessage.class, id));
    }

}
