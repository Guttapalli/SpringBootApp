package com.example.project1.Controller;

import com.example.project1.Repository.ProductRepository;
import com.example.project1.Repository.SalesItemsRepository;
import com.example.project1.Repository.SalesRepository;
import com.example.project1.modelEntities.Product;
import com.example.project1.modelEntities.SaleItems;
import com.example.project1.modelEntities.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    SalesRepository salesRepository;
    @Autowired
    SalesItemsRepository salesItemsRepository;
    @CrossOrigin(origins = "*")
   @GetMapping("/product/{id}")
    public ResponseEntity getProduct(
            @PathVariable(value = "id") int id){

       Optional product = productRepository.findById(id);
       return ResponseEntity.ok().body(product );
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/products")
    public ResponseEntity getAllProduct(
            ){

        Iterable product = productRepository.findAll();
        return ResponseEntity.ok().body(product );
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveProduct(
            @RequestBody Product product)
    {
         productRepository.save(product);
        return ResponseEntity.ok().body( "product saved successfully");
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteProduct(
            @PathVariable(value = "id") int id)
    {
        productRepository.deleteById(id);
        return ResponseEntity.ok().body( "product deleted successfully");
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/product/{id}")
    public ResponseEntity<Object> updateProduct(
            @RequestBody Product product,
            @PathVariable int id)
    {

        Optional productRepo
                = Optional.ofNullable(
                productRepository.findById(id));

        if (!productRepo.isPresent())
            return ResponseEntity
                    .notFound()
                    .build();

        product.setKey(id);


        productRepository.save(product);


        return ResponseEntity.ok().body( "product updated successfully");


    }

    @CrossOrigin(origins = "*")
    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveOrder(
            @RequestBody Sales sales)
    {
        salesRepository.save(sales);
        return ResponseEntity.ok().body( "Order saved successfully");
    }
    @PutMapping("/key")
    public ResponseEntity upDate(@RequestBody SaleItems saleitem) {
        // Assuming product.key is the primary key
        Optional<Product> optionalProduct = productRepository.findById(saleitem.productid);

        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            // Update the existingProduct with the new values from the request
           int newQuantity =existingProduct.getQuantity()-saleitem.getQuantity();
            existingProduct.setQuantity(newQuantity);
            // Save the updated product
            productRepository.save(existingProduct);

            return ResponseEntity.ok().body("Product updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/sales")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveSales(
            @RequestBody Sales sales)
    {
        salesRepository.save(sales);
        return ResponseEntity.ok().body( "product saved successfully");
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/saleitems")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveProduct(
            @RequestBody SaleItems saleItems)
    {
        salesItemsRepository.save(saleItems);
        return ResponseEntity.ok().body( "product saved successfully");
    }
}
