package com.dee.jpa.hibernate.many2one;

import javax.persistence.EntityManager;

import org.junit.Assert;

import com.dee.jpa.hibernate.EntityManagerUtil;
import com.dee.jpa.hibernate.model.many2one.GroupModel;
import com.dee.jpa.hibernate.model.many2one.UserModel;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 */

public class Many2OneTest extends TestCase{
    
    public void testUndirectionalMany2One() {
        
        GroupModel group = new GroupModel();
        group.setName("group1");
        UserModel user = new UserModel();
        user.setFullName("DienNM");
        user.setGroup(group);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(group);
        em.persist(user);
        
        em.getTransaction().commit();
        em.close();
        
        // Load Data
        em = EntityManagerUtil.getEntityManager();
        GroupModel pGroup = em.find(GroupModel.class, group.getId());
        Assert.assertNotNull(pGroup);
        
        UserModel pUser = em.find(UserModel.class, user.getId());
        Assert.assertNotNull(pUser);
        Assert.assertNotNull(pUser.getGroup());
    }
    
}
