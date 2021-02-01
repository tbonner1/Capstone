package com.hcl.service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.dao.ProductRepository;
import com.hcl.model.Product;

@Service 
@Transactional
public class ProductServiceImp implements ProductServiceInterface 
{
	@Autowired
	private ProductRepository prorepo;
	
	@Override
	public Product addProduct(Product pro) 
	{
		return prorepo.save(pro);
	}
	
	@Override
	public Set<Product> searchProducts(String search)
	{
		Set<Product> returnSet = prorepo.findByProductnameContaining(search);
		returnSet.addAll(prorepo.findByProductcategoryContaining(search));
		returnSet.addAll(prorepo.findByProductgenreContaining(search));
		returnSet.addAll(prorepo.findByProductconditionContaining(search));
		returnSet.addAll(prorepo.findByProductdescriptionContaining(search));
		
		return returnSet;
	}

	@Override
	public Set<Product> searchByCategory(String search) 
	{
		return prorepo.findByProductcategoryContaining(search);
	}

	@Override
	public Set<Product> searchByGenre(String search) 
	{
		return prorepo.findByProductgenreContaining(search);
	}

	@Override
	public void removeProduct(long productid) 
	{
		prorepo.deleteById(productid);
	}

	@Override
	public List<Product> getProducts() 
	{
		return prorepo.findAll();
	}

	@Override
	public Product getProductById(Long productId) 
	{
		return prorepo.findById(productId).get();
	}

	@Override
	public Boolean productExists(Long productId) 
	{
		try
		{
			prorepo.findById(productId).get();
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
		return true;
	}

	@Override
	public Set<String> getGenres() 
	{
		Set<String> genreSet = new HashSet<String>();
		
		for(Product p: prorepo.findAll())
		{
			genreSet.add(p.getProductgenre());
		}
	
		return genreSet;
	}

	@Override
	public Set<String> getCategories() 
	{
		Set<String> categorySet = new HashSet<String>();
		
		for(Product p: prorepo.findAll())
		{
			categorySet.add(p.getProductcategory());
		}
	
		return categorySet;
	}
	
	@Override
	public Set<String> getConditions() 
	{
		Set<String> conditionSet = new HashSet<String>();
		
		for(Product p: prorepo.findAll())
		{
			conditionSet.add(p.getProductcondition());
		}
	
		return conditionSet;
	}

}
