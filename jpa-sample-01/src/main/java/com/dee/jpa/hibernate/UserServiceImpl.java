package com.dee.jpa.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.dee.jpa.hibernate.model.UserModel;

/**
 * @author dien.nguyen
 **/

public class UserServiceImpl implements UserService {
    
    private EntityManager em;
    
    public UserServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public UserModel get(Long id) {
        return em.find(UserModel.class, id);
    }

    @Override
    public List<UserModel> getAll() {
        TypedQuery<UserModel> query = em.createQuery("FROM user_jpa_1", UserModel.class);
        return query.getResultList();
    }

    @Override
    public void save(UserModel user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void update(UserModel user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        UserModel user = em.find(UserModel.class, id);
        if(user != null) {
            em.remove(user);
        }
        em.getTransaction().commit();
    }

    @Override
    public void deleteAll() {
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM user_jpa_1");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
