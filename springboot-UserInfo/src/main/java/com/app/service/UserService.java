package com.app.service;

import java.util.List;

import com.app.entity.User;

public interface UserService 
{
   public User updateUser(User user);
   public void deleteUser(User user);
   public User findById(Long id);
   public List<User>findAll();
   public User saveUser(User user);
    public User getUserByEmailAndPassword(String email, String password);
   
}
