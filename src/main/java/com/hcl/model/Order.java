package com.hcl.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="orders")
public class Order 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long orderid;
	private int orderstatus = 0;

	@ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany
	@JoinTable(name = "orders_products", joinColumns = @JoinColumn(name = "products_productid"), inverseJoinColumns = @JoinColumn(name = "orders_orderid"))
    private Set<Product> products;
	
	@ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
	@JoinTable(name = "orders_users")
    private User user;
}
