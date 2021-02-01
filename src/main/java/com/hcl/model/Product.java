package com.hcl.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name="products")
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long productid;
	private String productname;
	private String productimage;
	private String productcategory;
	private String productgenre;
	private String productcondition;
	private float productprice;
	private String productdescription;
	
	@ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "products")
    private Set<Order> orders;
}
