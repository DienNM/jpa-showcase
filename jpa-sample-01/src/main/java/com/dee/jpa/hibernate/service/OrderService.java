package com.dee.jpa.hibernate.service;

import com.dee.jpa.hibernate.model.AddressModel;
import com.dee.jpa.hibernate.model.OrderEntityModel;
import com.dee.jpa.hibernate.model.OrderModel;

/**
 * @author dien.nguyen
 **/

public interface OrderService {
    
    OrderModel get(Long id);
    
    void save(OrderModel order, Long addressId) throws Exception;
    
    void changeAddress(OrderModel order, AddressModel address);
    
    void addOrderEntry(OrderModel order, OrderEntityModel orderEntity);
    
    void deleteAll();
    
}
