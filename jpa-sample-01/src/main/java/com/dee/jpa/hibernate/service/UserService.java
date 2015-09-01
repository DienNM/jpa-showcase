package com.dee.jpa.hibernate.service;

import java.util.List;

import com.dee.jpa.hibernate.model.UserModel;

/**
 * @author dien.nguyen
 **/

public interface UserService {
    
    UserModel get(Long id);
    
    List<UserModel> getAll();
    
    void save(UserModel user);
    
    void update(UserModel user);
    
    void delete(Long id);
    
    void deleteAll();
}
