package com.hcl.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
	Set<Product> findByProductnameContaining(String productname);
	Set<Product> findByProductcategoryContaining(String productcategory);
	Set<Product> findByProductgenreContaining(String productgenre);
	Set<Product> findByProductconditionContaining(String productcondition);
	Set<Product> findByProductdescriptionContaining(String productdescription);
}
