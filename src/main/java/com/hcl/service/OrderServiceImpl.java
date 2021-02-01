package com.hcl.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dao.OrderRepository;
import com.hcl.model.Order;
import com.hcl.model.Product;
import com.hcl.model.User;

@Service
@Transactional
public class OrderServiceImpl implements OrderServiceInterface
{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order addOrder(Order ord) 
	{
		return orderRepository.save(ord);
	}

	@Override
	public void removeOrder(Long orderid) 
	{
		orderRepository.deleteById(orderid);
	}

	@Override
	public List<Order> getOrders() 
	{
		return orderRepository.findAll();
	}

	@Override
	public Boolean addProduct(Order ord, Product pro) 
	{
		if(ord.getProducts().isEmpty())
			ord.setProducts(new HashSet<>());
		
		Boolean returnPro = ord.getProducts().add(pro);
		orderRepository.save(ord);
		return returnPro;
	}

	@Override
	public void removeProduct(Order ord, Product pro) 
	{
		if(ord.getProducts().isEmpty())
			return;
		for(Product p : ord.getProducts())
		{
			if(p.getProductid() == pro.getProductid())
			{
				ord.getProducts().remove(pro);
				return;
			}
		}
	}

	@Override
	public Set<Product> getProducts(Order ord) 
	{
		return ord.getProducts();
	}

	@Override
	public void shipOrder(Long orderid) 
	{
		Order order = orderRepository.findById(orderid).get();
		order.setOrderstatus(1);
		orderRepository.save(order);
	}

	@Override
	public void orderShipped(Long orderid) 
	{
		Order order = orderRepository.findById(orderid).get();
		order.setOrderstatus(2);
		orderRepository.save(order);
	}

	@Override
	public void cancelShipping(Long orderid)
	{
		Order order = orderRepository.findById(orderid).get();
		order.setOrderstatus(0);
		orderRepository.save(order);
	}

	@Override
	public User getUser(Long orderid) 
	{
		Order order = orderRepository.findById(orderid).get();
		return order.getUser();
	}

	@Override
	public Order getOrder(Long orderid) 
	{
		return orderRepository.findById(orderid).get();
	}

	
}
