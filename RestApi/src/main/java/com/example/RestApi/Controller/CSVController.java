package com.example.RestApi.Controller;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.RestApi.Service.CSVService;
//import com.example.RestApi.Service.InputStreamResource;
import com.example.RestApi.Service.ProductService;
import com.example.RestApi.helper.CSVHelper;
import com.example.RestApi.helper.ResponseMessage;
import com.example.RestApi.model.Product;

@Controller
@RequestMapping("/api/csv")
public class CSVController {

  @Autowired
  CSVService fileService;

 //PostMapping("/upload")
//public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) throws 
 //
  //String message = "";

  //if (CSVHelper.hasCSVFormat(file)) {
   // try {
   //   fileService.save(file);

  //    message = "Uploaded the file successfully: " + file.getOriginalFilename();
  //    return ResponseEntity.status(HttpStatus.OK).body());
   // } catch (Exception e) {
  //    message = "Could not upload the file: " + file.getOriginalFilename() + "!";
  //    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("")    }
  //}

  //message = "Please upload a csv file!";
  //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
 //

 //GetMapping("/Products")
 //ublic ResponseEntity<List<Product>> getAllTutorials() {
//  try {
 //   List<Product> products = fileService.getAllProducts();
  //  if (products.isEmpty()){
 //     return new ResponseEntity<>(HttpStatus.NO_CONTENT);
 //   }

 //   return new ResponseEntity<>(tutorials, HttpStatus.OK);
//  } catch (Exception e) {
 //   return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
 // }
//}

//@GetMapping("/download")
//public ResponseEntity<Resource> getFile() {
//  String filename = "tutorials.csv";
//  InputStream file = new InputStreamResource(fileService.load());

  //return ResponseEntity.ok()
  //    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
 //     .contentType(MediaType.parseMediaType("application/csv"))
//      .body(file);
//}

}
