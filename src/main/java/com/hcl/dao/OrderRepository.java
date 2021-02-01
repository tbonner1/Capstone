package com.hcl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hcl.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>
{
	
}
