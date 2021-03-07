package com.example.RestApi.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.RestApi.Repository.ProductRepository;
import com.example.RestApi.helper.CSVHelper;
import com.example.RestApi.model.Product;

@Service
public class CSVService {
	
  @Autowired
  ProductRepository<Product> repository;

  public void save(MultipartFile file) {
    try {
      List<Product> products = CSVHelper.csvToProducts(file.getInputStream());
      repository.saveAll(products);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public ByteArrayInputStream load(){
    List<Product> products = repository.findAll();

    ByteArrayInputStream in = CSVHelper.productsToCSV(products);
    return in;
  }

  public List<Product> getAllProducts() {
    return repository.findAll();
  }
}
