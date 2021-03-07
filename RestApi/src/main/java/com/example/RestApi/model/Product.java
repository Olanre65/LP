package com.example.RestApi.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long Id;
	
	@Column(name="Desc")
	private String description;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "Category_Id", referencedColumnName = "Category_Id")
	@Column(name="Category_Id")
	private Integer Category_Id;
	
	@Column(name="Creation_Date")
	private LocalDateTime creationdate;
	
	@Column(name="UPDATE_DATE")
	private LocalDateTime updateAt;
	
	@Column(name="Last_Purchased_Date")
	private LocalDateTime lastpurchasedDate;
	
	public Product() {
		}
	
	public Product(Long id, String description, Integer category_Id, LocalDateTime creationdate, LocalDateTime updateAt,
			LocalDateTime lastpurchasedDate) {
		super();
		Id = id;
		this.description = description;
		Category_Id = category_Id;
		this.creationdate = creationdate;
		this.updateAt = updateAt;
		this.lastpurchasedDate = lastpurchasedDate;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCategory_Id() {
		return Category_Id;
	}

	public void setCategory(Integer category_Id) {
		Category_Id = category_Id;
	}

	public LocalDateTime getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(LocalDateTime localDateTime) {
		this.creationdate = localDateTime;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public LocalDateTime getLastpurchasedDate() {
		return lastpurchasedDate;
	}

	public void setLastpurchasedDate(LocalDateTime lastpurchasedDate) {
		this.lastpurchasedDate = lastpurchasedDate;
	}

	@Override
	public String toString() {
		return "Products [Id=" + Id + ", description=" + description + ", Category=" + Category_Id + ", creationdate="
				+ creationdate + ", updateAt=" + updateAt + ", lastpurchasedDate=" + lastpurchasedDate + "]";
	}

	}
