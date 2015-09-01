package com.dee.jpa.hibernate.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;

import com.dee.jpa.hibernate.model.AddressModel;
import com.dee.jpa.hibernate.model.OrderEntityModel;
import com.dee.jpa.hibernate.model.OrderModel;
import com.dee.jpa.hibernate.service.OrderService;

/**
 * @author dien.nguyen
 **/

public class OrderServiceImpl implements OrderService {
    
    private EntityManager em;
    
    public OrderServiceImpl(EntityManager em) {
        this.em = em;
    }
    
    @Override
    public OrderModel get(Long id) {
        return em.find(OrderModel.class, id);
    }

    @Override
    public void save(OrderModel order, Long addressId) throws Exception {
        AddressModel address = em.getReference(AddressModel.class, addressId);
        Assert.assertNotNull(address.getAddress());
        Assert.assertNotNull(address.getPhone());
        
        order.setDeliveryAddress(address);
        em.getTransaction().begin();
        em.persist(order);
        em.getTransaction().commit();
    }
    
    @Override
    public void changeAddress(OrderModel order, AddressModel address) {
        em.getTransaction().begin();
        order.setDeliveryAddress(address);
        em.merge(order);
        em.getTransaction().commit();
    }

    @Override
    public void addOrderEntry(OrderModel order, OrderEntityModel orderEntity) {
        em.getTransaction().begin();
        order.getOrderEntities().add(orderEntity);
        em.persist(order);
        em.getTransaction().commit();
    }
    
    @Override
    public void deleteAll() {
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM OrderModel");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
