package com.example.RestApi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class category {
	
	@Id
	private Long Category_Id;
	private String Category_name;
	
	
	public category(Long category_Id, String category_name) {
		
		Category_Id = category_Id;
		Category_name = category_name;
	}


	public Long getCategory_Id() {
		return Category_Id;
	}


	public void setCategory_Id(Long category_Id) {
		Category_Id = category_Id;
	}


	public String getCategory_name() {
		return Category_name;
	}


	public void setCategory_name(String category_name) {
		Category_name = category_name;
	}


	@Override
	public String toString() {
		return "category [Category_Id=" + Category_Id + ", Category_name=" + Category_name + "]";
	}
	
	
	
	

}
