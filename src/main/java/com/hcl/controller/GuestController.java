package com.hcl.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hcl.model.Product;
import com.hcl.service.ProductServiceInterface;

@Controller
public class GuestController 
{
	@Autowired
	private ProductServiceInterface proservice;
	
	@RequestMapping(value= {"/","/home"})
	public String mainhome() 
	{
		return "home";		
	}
	
	@GetMapping("/about")
	public String about() 
	{
		return "about";		
	}
	
	@RequestMapping("/login")
	public String login() 
	{
		return "login";		
	}
	
	@GetMapping("/register")
	public String showRegister() 
	{
		return "register";		
	}
	
	@RequestMapping("/403")
	public String accessdenied() 
	{
		return "403";		
	}
	
	//View Products
	@GetMapping("/viewproducts")
	public ModelAndView getProducts() 
	{
		List<Product> products = proservice.getProducts();
		return new ModelAndView("viewproducts", "products", products);
	}
		
	@PostMapping("/viewproducts/productdetails/{productid}")
	public ModelAndView getProductDetails(@PathVariable String productid) 
	{
		Product product = proservice.getProductById(Long.parseLong(productid));
		return new ModelAndView("productview", "product", product);
	}
	
	//Search Products
	@PostMapping("/viewproducts/search/")
	public ModelAndView searchProducts(@RequestParam String search) 
	{
		Set<Product> products = proservice.searchProducts(search);
		return new ModelAndView("viewproducts", "products", products);
	}
	
}
