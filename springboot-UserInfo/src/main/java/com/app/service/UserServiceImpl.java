package com.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.entity.User;
import com.app.repo.UserRepository;

@Service
public class UserServiceImpl  implements UserService
{
	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(User user)
	{
		userRepository.delete(user);	
	}

	@Override
	public User findById(Long id) 
	{
		return userRepository.findById(id).get();
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	
	}

	@Override
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User getUserByEmailAndPassword(String email, String password) {
		
		return userRepository.findByEmailAndPassword(email, password);
	}
}
