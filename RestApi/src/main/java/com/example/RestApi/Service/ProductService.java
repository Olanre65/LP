package com.example.RestApi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.RestApi.Exception.ProductNotFoundException;
import com.example.RestApi.Repository.ProductRepository;
import com.example.RestApi.model.Product;

@Service
 public class ProductService {
	
	@Autowired
	ProductRepository <Product> repos;
	
   public List<Product> getAllProducts(Integer pageNo, Integer pageSize, String sortBy) {
		
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		
		Page <Product> pagedResult = repos.findAll(paging);
		
		if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
		return new ArrayList<Product>();
        }
	}
	
   public Product getProductById(Long Id) throws ProductNotFoundException{
	   
	   Optional<Product>product = repos.findById(Id);
	   
	   if(product.isPresent()){
		   return product.get();
	   }else {
		   throw new ProductNotFoundException("No product record exist for given id");
		   
	   }
	   
   }
   public Product createorUpdate(Product entity) throws ProductNotFoundException{
	   
	   Optional<Product> product = repos.findById(entity.getId());
	   if(product.isPresent()) {
		   Product newEntity = product.get();
		   newEntity.setDescription(entity.getDescription());
		   newEntity.setCategory(entity.getCategory_Id())  ;
		   newEntity.setCreationdate(entity.getCreationdate());
		   newEntity.setLastpurchasedDate(entity.getLastpurchasedDate());
		   newEntity.setUpdateAt(entity.getUpdateAt());
		   newEntity.setLastpurchasedDate(entity.getLastpurchasedDate());
		   
		   newEntity =repos.save(newEntity);
		   
		   return newEntity;
	       }else {
	    	   entity =  repos.save(entity);
	             
	            return entity; 
		   }
		  
	   }
   
   public void deleteProductById(Long Id) throws ProductNotFoundException{
	   Optional<Product> product = repos.findById(Id);
	   if(product.isPresent()) {
		  repos.deleteById(Id);
	   }else {}
   }
}