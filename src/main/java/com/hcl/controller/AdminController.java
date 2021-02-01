package com.hcl.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.Order;
import com.hcl.model.Product;
import com.hcl.model.User;
import com.hcl.service.OrderServiceInterface;
import com.hcl.service.ProductServiceInterface;
import com.hcl.service.UserDetailsServiceImpl;

@RestController
@RequestMapping
public class AdminController 
{
	@Autowired
	private ProductServiceInterface proservice;
	
	@Autowired
	private UserDetailsServiceImpl usrservice;
	
	@Autowired
	private OrderServiceInterface orderservice;
	
	@GetMapping("/admin")
	public ModelAndView admin() 
	{
		return new ModelAndView("admin");
	}
	/////////////////////////////////////////
	//PRODUCTS
	/////////////////////////////////////////
	//View Products
	@GetMapping("/admin/editproducts")
	public ModelAndView getProducts() 
	{
		List<Product> products = proservice.getProducts();
		return new ModelAndView("editproducts", "products", products);
	}
	
	//View Products By Genre
	@GetMapping("/admin/genres")
	public ModelAndView getProductsByGenre() 
	{
		Set <String> genres = proservice.getGenres();
		return new ModelAndView("genre", "genres", genres);
	}
	@PostMapping("/admin/editproducts/genre")
	public ModelAndView getProductsByGenre(@RequestParam String chosenGenre) 
	{
		System.out.println("Chosen genre is " + chosenGenre);
		Set<Product> products = proservice.searchByGenre(chosenGenre);
		return new ModelAndView("editproducts", "products", products);
	}
	
	//View Products By Category
	@GetMapping("/admin/categories")
	public ModelAndView getProductsByCategory() 
	{
		Set <String> categories = proservice.getCategories();
		return new ModelAndView("category", "categories", categories);
	}
	@PostMapping("/admin/editproducts/categories")
	public ModelAndView getProductsByCategory(@RequestParam String chosenCategory) 
	{
		System.out.println("Chosen category is " + chosenCategory);
		Set<Product> products = proservice.searchByCategory(chosenCategory);
		return new ModelAndView("editproducts", "products", products);
	}
		
	//Delete Product 
	@PostMapping("/admin/editproducts/delete")
	public ModelAndView deleteProduct(@RequestParam String productid) 
	{
		if (proservice.productExists(Long.parseLong(productid)))
		{
			proservice.removeProduct(Long.parseLong(productid));
			return new ModelAndView("delete");
		}
		else
			return new ModelAndView("deletefail");
	}
	
	//Edit Products
	@PostMapping("/admin/editproducts/edit")
	public ModelAndView editProduct(@RequestParam String productid) 
	{
		if (proservice.productExists(Long.parseLong(productid)))
		{
			ModelAndView mv = new ModelAndView("product");
			Product pro = proservice.getProductById(Long.parseLong(productid));
			Set<String> productgenres = proservice.getGenres();
			Set<String> productcategories = proservice.getCategories();
			Set<String> productcoditions = proservice.getConditions();
			mv.addObject("pro", pro);
			mv.addObject("productgenres", productgenres);
			mv.addObject("productcategories", productcategories);
			mv.addObject("productcoditions", productcoditions);
			return mv;
		}
		else
			return new ModelAndView("productfail");
	}
	//Save Edits
	@PostMapping("/admin/editproducts/product")
	public ModelAndView product(@RequestParam String productid, @RequestParam String productprice, @RequestParam String productname, @RequestParam String productdescription, @RequestParam String productimage, @RequestParam String productgenre, @RequestParam String productcategory, @RequestParam String productcondition) 
	{
		if (proservice.productExists(Long.parseLong(productid)))
		{
			Product pro = proservice.getProductById(Long.parseLong(productid));
			pro.setProductname(productname);
			pro.setProductprice(Float.parseFloat(productprice));
			pro.setProductdescription(productdescription);
			pro.setProductimage(productimage);
			pro.setProductgenre(productgenre);
			pro.setProductcategory(productcategory);
			pro.setProductcondition(productcondition);
			proservice.addProduct(pro);
			return new ModelAndView("redirect:/admin/editproducts");
		}
		else
			return new ModelAndView("productfail");
	}
	
	/////////////////////////////////////////
	//USERS
	/////////////////////////////////////////
	//View Users
	@GetMapping("/admin/editusers")
	public ModelAndView getUsers() 
	{
		List<User> users = usrservice.getUsers();
		return new ModelAndView("editusers", "users", users);
	}
		
	//Delete User
	@PostMapping("/admin/editusers/delete")
	public ModelAndView deleteUser(@RequestParam String userid) 
	{
		if (usrservice.userExists(Long.parseLong(userid)))
		{
			usrservice.deleteUser(Long.parseLong(userid));
			return new ModelAndView("delete");
		}
		else
			return new ModelAndView("deletefail");
	}
	
	//Edit User
	@PostMapping("/admin/editusers/edit")
	public ModelAndView editUser(@RequestParam String userid) 
	{
		if (usrservice.userExists(Long.parseLong(userid)))
		{
			ModelAndView mv = new ModelAndView("user");
			User usr = usrservice.getUserById(Long.parseLong(userid));
			mv.addObject("usr", usr);
			return mv;
		}
		else
			return new ModelAndView("userfail");
	}
	
	//Save Edits
	@PostMapping("/admin/editusers/user")
	public ModelAndView user(@RequestParam String userid, @RequestParam String username, @RequestParam String useremail, @RequestParam String userphone, @RequestParam String userpassword, @RequestParam String useraddress, @RequestParam String usercity, @RequestParam String userstate, @RequestParam String usercountry, @RequestParam String userzip) 
	{
		if (usrservice.userExists(Long.parseLong(userid)))
		{
			User usr = usrservice.getUserById(Long.parseLong(userid));
			usr.setUsername(username);
			usr.setUseremail(useremail);
			usr.setUserphone(Long.parseLong(userphone));
			usr.setUserpassword(userpassword);
			usr.setUseraddress(useraddress);
			usr.setUsercity(usercity);
			usr.setUserstate(userstate);
			usr.setUsercountry(usercountry);
			usr.setUserzip(Long.parseLong(userzip));
			usrservice.saveUser(usr);
			return new ModelAndView("redirect:/admin/editusers");
		}
		else
			return new ModelAndView("userfail");
	}
	
	/////////////////////////////////////////
	//ORDERS
	/////////////////////////////////////////
	//View Orders
	@GetMapping("/admin/editorders")
	public ModelAndView getOrders() 
	{
		List<Order> orders = orderservice.getOrders();
		return new ModelAndView("editorders", "orders", orders);
	}
	
	//Delete Order
	@PostMapping("/admin/editorders/delete")
	public ModelAndView deleteOrder(@RequestParam String orderid) 
	{
		orderservice.removeOrder(Long.parseLong(orderid));
		return new ModelAndView("redirect:/admin/editorders");
	}
	
	//Edit Order
	@PostMapping("/admin/editorders/edit")
	public ModelAndView editOrder(@RequestParam String orderid) 
	{
		ModelAndView mv = new ModelAndView("order");
		Order ord = orderservice.getOrder(Long.parseLong(orderid));
		mv.addObject("ord", ord);
		return mv;
	}
	
	//Save Edits
	@PostMapping("/admin/editorders/order")
	public ModelAndView order(@RequestParam String orderid, @RequestParam String orderstatus) 
	{
		Order ord = orderservice.getOrder(Long.parseLong(orderid));
		ord.setOrderstatus(Integer.parseInt(orderstatus));
		orderservice.addOrder(ord);
		return new ModelAndView("redirect:/admin/editorders");
	}
	
	//Initialize Products with some test products
	@RequestMapping("/admin/pop")  
	public ModelAndView proInit()   
	{ 
		Product pro = new Product();
		
		pro.setProductname("Abbey Road");
		pro.setProductimage("http://stuffnobodycaresabout.com/wp-content/uploads/2015/04/Abbey-Road-cover.jpg");
		pro.setProductcategory("CDs");
		pro.setProductgenre("Rock & Roll");
		pro.setProductcondition("OLD");
		pro.setProductprice(12.99f);
		pro.setProductdescription("Great album");
		
		proservice.addProduct(pro);
		
		Product pro2 = new Product();
		
		pro2.setProductname("BSSM");
		pro2.setProductimage("https://jamesostafford.files.wordpress.com/2015/08/rhcp-blood-sugar.jpg");
		pro2.setProductcategory("CDs");
		pro2.setProductgenre("Rock & Roll");
		pro2.setProductcondition("USED");
		pro2.setProductprice(5.99f);
		pro2.setProductdescription("Good album");
		
		proservice.addProduct(pro2);
		
		Product pro3 = new Product();
		
		pro3.setProductname("Steely Dan");
		pro3.setProductimage("https://vinylconnect.files.wordpress.com/2015/10/steely-dan-aja.jpg");
		pro3.setProductcategory("Vinyl");
		pro3.setProductgenre("Jazz");
		pro3.setProductcondition("WORN");
		pro3.setProductprice(0.99f);
		pro3.setProductdescription("Fantastic album");
		
		proservice.addProduct(pro3);
		
		return new ModelAndView("redirect:/admin");
	}
}
