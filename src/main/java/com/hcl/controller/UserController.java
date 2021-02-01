package com.hcl.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.Order;
import com.hcl.model.Product;
import com.hcl.model.User;
import com.hcl.service.OrderServiceInterface;
import com.hcl.service.ProductServiceInterface;
import com.hcl.service.UserDetailsServiceImpl;

@Controller
public class UserController 
{
	@Autowired
	private UserDetailsServiceImpl usrservice;
	
	@Autowired
	private OrderServiceInterface orderservice;
	
	@Autowired
	private ProductServiceInterface proservice;
	
	//View User info
	@GetMapping("/user/{username}")
	public ModelAndView userInfo(@PathVariable String username) 
	{
		User usr = usrservice.getUserByName(username);
		return new ModelAndView("userinfo", "usr", usr);
	}
	
	//Save User Info
	@GetMapping("/user/save")
	public ModelAndView saveUserInfo(@RequestParam String username, @RequestParam String useremail,  @RequestParam String userpassword, @RequestParam String userphone, @RequestParam String useraddress, @RequestParam String usercity, @RequestParam String userstate, @RequestParam String usercountry, @RequestParam String userzip) 
	{
		User u = usrservice.getUserByName(username);
		u.setUsername(username);
		u.setUseremail(useremail);
		u.setUserpassword(userpassword);
		u.setUserphone(Long.parseLong(userphone));
		u.setUseraddress(useraddress);
		u.setUsercity(usercity);
		u.setUserstate(userstate);
		u.setUsercountry(usercountry);
		u.setUserzip(Long.parseLong(userzip));
		usrservice.saveUser(u);
		return new ModelAndView("userinfo");
	}
		
	@PostMapping("/user/order/addproduct/{productid}")
	public ModelAndView saveProductToCart(@PathVariable String productid, HttpServletRequest request) 
	{
		Product product = proservice.getProductById(Long.parseLong(productid));
		User user = usrservice.getUserById(usrservice.getUserIdByUsername(request.getRemoteUser()));
		Order order = usrservice.getOrder(user);
		orderservice.addProduct(order, product);
		return new ModelAndView("productsaved", "user", user);
	}
	//View Cart
	@GetMapping("/user/cart/{username}")
	public ModelAndView cart(@PathVariable String username) 
	{
		User user = usrservice.getUserByName(username);
		Order order = usrservice.getOrder(user);
		Set<Product> products = orderservice.getProducts(order);
		ModelAndView mv = new ModelAndView("cart");
		mv.addObject("order", order);
		mv.addObject("user", user);
		mv.addObject("products", products);
		return mv;
	}
	
	//Change Shipping Info
	@PostMapping("/user/cart/shippinginfo/{orderid}")
	public ModelAndView shippinginfo(@PathVariable String orderid) 
	{
		User user = orderservice.getUser(Long.parseLong(orderid));
		ModelAndView mv = new ModelAndView("shippinginfo");
		mv.addObject("user", user);
		mv.addObject("orderid", orderid);
		return mv;
	}
	//Ship Cart
	@PostMapping("/users/cart/ship/{orderid}")
	public ModelAndView shipCart(@PathVariable String orderid) 
	{
		User user = orderservice.getUser(Long.parseLong(orderid));
		orderservice.shipOrder(Long.parseLong(orderid));
		ModelAndView mv = new ModelAndView("ordershipped");
		mv.addObject("user", user);
		return mv;
	}
	
	@PostMapping("/register")
	public String register(@RequestParam String username, @RequestParam String useremail, @RequestParam String userpassword, @RequestParam String userphone, @RequestParam String useraddress, @RequestParam String usercity, @RequestParam String userstate, @RequestParam String usercountry, @RequestParam String userzip) 
	{
		User u = new User();
		u.setUsername(username);
		System.out.println("User exists" + usrservice.checkIfUseremailExist(useremail));
		u.setUseremail(useremail);
		u.setUserpassword(userpassword);
		u.setUserphone(Long.parseLong(userphone));
		u.setUseraddress(useraddress);
		u.setUsercity(usercity);
		u.setUserstate(userstate);
		u.setUsercountry(usercountry);
		u.setUserzip(Long.parseLong(userzip));
		System.out.println("NEW User " + usrservice.saveUser(u));
		return "login";
	}
	
	@PostMapping("/hello")
	public String hello2(HttpServletRequest request) 
	{
		System.out.println("Remote user is " + usrservice.loadUserByUsername(request.getRemoteUser()));
		return "home";
		
	}
}
