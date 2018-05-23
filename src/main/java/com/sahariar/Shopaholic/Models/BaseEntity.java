package com.sahariar.Shopaholic.Models;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseEntity {

	private Date createdDate;
	private Date lastModifiedDate;
	public Date getCreatedDate() {
		return createdDate;
	}
	@PrePersist
	public void setCreatedDate() {
		this.createdDate = new Date();
		this.lastModifiedDate=new Date();
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	
	@PreUpdate
	public void setLastModifiedDate() {
		this.lastModifiedDate = new Date();
	}
	
   	
	
}
