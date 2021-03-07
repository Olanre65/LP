package com.example.RestApi.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.RestApi.model.Product;

public interface ProductRepository<ProductsEntity> extends PagingAndSortingRepository<Product,Long > {
	
	

}
