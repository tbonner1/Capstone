package com.hcl.service;

import java.util.List;

import com.hcl.model.Order;
import com.hcl.model.User;

public interface UserServiceInterface 
{
	public Long saveUser(User user);
	public List<User> getUsers();
	public boolean checkIfUseremailExist(String useremail);
	public void deleteUser(Long userid);
	public User getUserByName(String username);
	public User getUserById(Long userid);
	public boolean userExists(Long userid);
	public Order getOrder(User user);
	public Long getUserIdByUsername(String username);
}
