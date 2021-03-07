package com.example.RestApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestApi.Exception.ProductNotFoundException;
import com.example.RestApi.Service.ProductService;
import com.example.RestApi.model.Product;

@RestController
@RequestMapping("/Products")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	
	public ResponseEntity<List<Product>> getAllProducts(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy)
{
List<Product> list = service.getAllProducts(pageNo, pageSize, sortBy);

return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
}
	 @GetMapping("/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id)
	                                                    throws ProductNotFoundException {
	        Product product = service.getProductById(id);
	 
	        return new ResponseEntity<Product>(product, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	 @PostMapping
	    public ResponseEntity<Product> createOrUpdate(Product product)
	                                                    throws ProductNotFoundException {
	        Product updated = service.createorUpdate(product);
	        return new ResponseEntity<Product>(updated, new HttpHeaders(), HttpStatus.OK);
	    }
	 
	 @DeleteMapping("/{id}")
	    public HttpStatus deleteProductById(@PathVariable("id") Long id)
	                                                    throws ProductNotFoundException {
	        service.deleteProductById(id);
	        return HttpStatus.FORBIDDEN;
	    }

}
	
	
         
