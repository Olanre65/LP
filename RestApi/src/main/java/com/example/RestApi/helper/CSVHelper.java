package com.example.RestApi.helper;



import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.QuoteMode;
import org.springframework.web.multipart.MultipartFile;

import com.example.RestApi.model.Product;


public class CSVHelper {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "Id", "Title", "Description", "Published" };

  public static boolean hasCSVFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static List<Product> csvToProducts(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<Product> products = new ArrayList<Product>();
      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        DateTimeFormatter ISO_LOCAL_DATE_TIME = null;
		Product product = new Product (
              Long.parseLong(csvRecord.get("Id")),
              csvRecord.get("description"),
              Integer.parseInt(csvRecord.get("Category_Id")),
              LocalDateTime.parse(csvRecord.get("creationdate"), ISO_LOCAL_DATE_TIME),
              LocalDateTime.parse(csvRecord.get("updateAt"),ISO_LOCAL_DATE_TIME),
              LocalDateTime.parse(csvRecord.get("lastpurchasedDate"),ISO_LOCAL_DATE_TIME)          		  
            );

        products.add(product);
      }

      return products;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static ByteArrayInputStream productsToCSV(List<Product> products) {
    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
      for (Product product : products) {
        DateTimeFormatter ISO_LOCAL_DATE_TIME = null;
		List<Object> data = Arrays.asList(
              product.getId(),
              product.getDescription(),
              product.getCategory_Id(),
              product.getCreationdate().format(ISO_LOCAL_DATE_TIME),
              product.getUpdateAt().format(ISO_LOCAL_DATE_TIME),
              product.getLastpurchasedDate().format(ISO_LOCAL_DATE_TIME)
            );

        csvPrinter.printRecord(data);
      }

      csvPrinter.flush();
      return new ByteArrayInputStream(out.toByteArray());
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
    }
  }

}

