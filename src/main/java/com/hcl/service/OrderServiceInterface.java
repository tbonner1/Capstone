package com.hcl.service;

import java.util.List;
import java.util.Set;

import com.hcl.model.Order;
import com.hcl.model.Product;
import com.hcl.model.User;

public interface OrderServiceInterface 
{
	public Order addOrder(Order ord);
	public Order getOrder(Long orderid);
	public void removeOrder(Long orderid);
	public List<Order> getOrders();
	public Boolean addProduct(Order ord, Product pro);
	public void removeProduct(Order ord, Product pro);
	public Set<Product> getProducts(Order ord);
	public void shipOrder(Long orderid);
	public void orderShipped(Long orderid);
	public void cancelShipping(Long orderid);
	public User getUser(Long orderid);
}
