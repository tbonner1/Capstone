package com.hcl.service;

import java.util.List;
import java.util.Set;

import com.hcl.model.Product;

public interface ProductServiceInterface 
{
	public Product addProduct(Product pro);
	
	public Product getProductById(Long productId);
	
	public Boolean productExists(Long productId);
	
	public Set<Product> searchProducts(String search);
	
	public Set<Product> searchByCategory(String search);
	
	public Set<Product> searchByGenre(String search);
	
	public void removeProduct(long productid);
	
	public List<Product> getProducts();
	
	public Set<String> getGenres();
	
	public Set<String> getCategories();
	
	public Set<String> getConditions();
}
