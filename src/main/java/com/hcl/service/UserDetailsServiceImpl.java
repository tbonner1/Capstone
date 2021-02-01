package com.hcl.service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hcl.dao.OrderRepository;
import com.hcl.dao.RoleRepository;
import com.hcl.dao.UserRepository;
import com.hcl.model.Order;
import com.hcl.model.Product;
import com.hcl.model.Role;
import com.hcl.model.User;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserServiceInterface, UserDetailsService 
{
	@Autowired
	private UserRepository userRepository;

	@Autowired
    private RoleRepository roleRepository;
	
	@Autowired
    private OrderRepository orderRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Long saveUser(User user) 
	{
		String encodedPasswod = passwordEncoder.encode(user.getUserpassword());
		user.setUserpassword(encodedPasswod);
		System.out.println("Is user null?");
		if(user.getRoles().isEmpty())
			user.setRoles(new HashSet<>());
		
		user.getRoles().add(roleRepository.findByRolename("ROLE_USER"));

		userRepository.save(user);
		return user.getUserid();
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user=userRepository.findByUsername(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	       
		System.out.println(user.getRoles().toString());
		for (Role role : user.getRoles())
		{
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRolename()));
	    }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getUserpassword(), grantedAuthorities);
	}

	@Override
	public List<User> getUsers() 
	{
		return userRepository.findAll();
	}

	 @Override
	 public boolean checkIfUseremailExist(String useremail) 
	 {
	        return userRepository.findByUseremail(useremail) !=null ? true : false;
	 }
	
	 @Override
	 public void deleteUser(Long userid)
	 {
		 userRepository.deleteById(userid);
	 }

	@Override
	public User getUserById(Long userid) 
	{
		return userRepository.findById(userid).get();
	}

	@Override
	public boolean userExists(Long userid) 
	{
		try
		{
			userRepository.findById(userid).get();
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
		return true;
	}

	@Override
	public Order getOrder(User user) 
	{
		Set<Order> orders = user.getOrders();
		if(orders.isEmpty())
		{
			Order newOrder = new Order();
			Set<Product> products = new HashSet<Product>();
			newOrder.setProducts(products);
			newOrder.setUser(user);
			return newOrder = orderRepository.save(newOrder);
		}
		else
		{
			for(Order o: orders)
			{
				if (o.getOrderstatus() == 0)
					return o;
			}
			
			Order newOrder = new Order();
			Set<Product> products = new HashSet<Product>();
			newOrder.setProducts(products);
			newOrder.setUser(user);
			return newOrder = orderRepository.save(newOrder);
		}	
	}

	@Override
	public Long getUserIdByUsername(String username) 
	{
		User user = userRepository.findByUsername(username);
		return user.getUserid();
	}

	@Override
	public User getUserByName(String username) 
	{
		return userRepository.findByUsername(username);
	}
	
	
}
