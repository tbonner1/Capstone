package com.hcl.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "users")
@SequenceGenerator(name="seq", sequenceName="userid", initialValue = 3, allocationSize = 1)
public class User 
{
	 @Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")  
	 private Long userid;
	 private String username;
	 private String useremail;
	 private Long userphone;
	 private String userpassword;
	 private String useraddress;
	 private String usercity;
	 private String userstate;
	 private String usercountry;
	 private Long userzip;
	 
	 @ToString.Exclude
	 @EqualsAndHashCode.Exclude
	 @ManyToMany
	 @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "users_userid"), inverseJoinColumns = @JoinColumn(name = "roles_roleid"))   
	 private Set<Role> roles;

	 @ToString.Exclude
	 @EqualsAndHashCode.Exclude
	 @OneToMany(mappedBy = "user")
	 private Set<Order> orders;
}
