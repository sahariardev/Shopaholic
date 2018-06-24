package com.sahariar.Shopaholic.Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class User extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long Id;
	
	private String email;
	private String name;
	
	@OneToOne
	private Address address;
	
	
	
}
