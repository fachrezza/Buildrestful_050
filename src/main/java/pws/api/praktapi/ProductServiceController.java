/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pws.api.praktapi;

import java.util.HashMap;
import java.util.Map;
import model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author A S U S
 */

//restcontroller digunakan untuk mendefinisikan layanan web RESTful. restcontroller melayani JSON, XML, dan respons khusus.
@RestController

//membuat public class bernama ProductServiceController
public class ProductServiceController {
    
    //membuat HashMap, HashMap berfungsi untuk menyimpan data
    private static Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product(); //mendeklarasikan class ke object
        honey.setId("1");
        honey.setNama("Honey");
        honey.setPrice(10000);
        honey.setDisc(10);
        productRepo.put(honey.getId(), honey); //memanggil id dan product
        
//        Product almond = new Product();//mendeklarasikan class ke object
//        almond.setId("2");
//        almond.setNama("Almond");
//        productRepo.put(almond.getId(), almond);//memanggil id dan product
    }
    
    //request mapping digunakan untuk menentukan Request URI untuk mengakses REST Endpoints
    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
    //request mapping digunakan untuk menentukan Request URI untuk mengakses REST Endpoints
    @RequestMapping(value ="/products", method = RequestMethod.POST)
    
    //membuat public responseentity<object> untuk create product
    //requestbody digunakan untuk menentukan jenis konten
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
        
        //menggunakan metode if else untuk menentukan jika produk sudah ada tidak bisa input lagi, jika belum ada maka bisa input
        if(productRepo.containsKey(product.getId())){
            return new ResponseEntity<>("Product sudah ada", HttpStatus.CREATED);
        }
        else{
            productRepo.put(product.getId(), product);
            return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
        }
        
    }
    //request mapping digunakan untuk menentukan Request URI untuk mengakses REST Endpoints
    @RequestMapping(value="/products/{id}", method = RequestMethod.PUT)
    
    //membuat public responseEntity<object> untuk update produk menggunakan id
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product){
        
        //menggunakan metode if else untuk menentukan jika produk belum ada, jika produk belum ada, maka tidak bisa update
        if(!productRepo.containsKey(id)){
            return new ResponseEntity<>("Produk id tidak ditemukan", HttpStatus.OK);
        }
        else {
            productRepo.remove(id);
            product.setId(id);
            productRepo.put(id, product);
            return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
        }

        
    }
    //request mapping digunakan untuk menentukan Request URI untuk mengakses REST Endpoints
    @RequestMapping(value="/products/{id}", method = RequestMethod.DELETE)
    //membuat public responseEntity<object> untuk delete produk menggunakan id
    public ResponseEntity<Object> delete(@PathVariable("id") String id){ 
        
        //menggunakan metode if else untuk menentukan jika produk belum ada, jika produk belum ada, maka tidak bisa delete
        if(!productRepo.containsKey(id)){
            return new ResponseEntity<>("Produk id tidak ditemukan", HttpStatus.OK); //jika produk tidak ada maka akan menampilkan "Produk id tidak ditemukan"
        }
        else {
        productRepo.remove(id);
        //memberikan respon jika produk sudah dihapus "Product is deleted successfully"
        return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
        }
        
    }
}

