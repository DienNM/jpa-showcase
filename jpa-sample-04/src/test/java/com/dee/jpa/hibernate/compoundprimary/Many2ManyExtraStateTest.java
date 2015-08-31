package com.dee.jpa.hibernate.compoundprimary;

import javax.persistence.EntityManager;

import com.dee.jpa.hibernate.EntityManagerUtil;
import com.dee.jpa.hibernate.relationship.extrastate.Order;
import com.dee.jpa.hibernate.relationship.extrastate.OrderEntry;
import com.dee.jpa.hibernate.relationship.extrastate.Product;

import junit.framework.TestCase;

/**
 * @author dien.nguyen
 **/

public class Many2ManyExtraStateTest extends TestCase {
    
    public void testExtraState() {
        
        Product product1 = new Product();
        product1.setName("product 1");
        
        Product product2 = new Product();
        product2.setName("product 2");
        
        Order order = new Order();
        order.setId("ORD0001");
        order.setTotal(80);
        
        
        OrderEntry orderEntry1 = new OrderEntry();
        orderEntry1.setAmount(2);
        orderEntry1.setPrice(10);
        orderEntry1.setProduct(product1);
        orderEntry1.setOrder(order);
        
        OrderEntry orderEntry2 = new OrderEntry();
        orderEntry2.setAmount(3);
        orderEntry2.setPrice(20);
        orderEntry2.setProduct(product2);
        orderEntry2.setOrder(order);
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(product1);
        em.persist(product2);
        em.persist(order);
        
        em.persist(orderEntry1);
        em.persist(orderEntry2);
        
        em.getTransaction().commit();
        em.close();
        
    }
    
}
