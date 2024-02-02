package org.example.hexagonalarchitecture01.infrastructure.controllers;

import org.example.hexagonalarchitecture01.application.services.ProductService;
import org.example.hexagonalarchitecture01.domain.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product createdProduct =  productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<Product> getByUuid(@PathVariable String uuid){

        return productService.getProduct(uuid).map(product -> new ResponseEntity<>(product,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity <List<Product>> getAll(){
        List<Product> products = productService.listProducts();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Boolean> delete(@PathVariable String uuid){
        Boolean bool = productService.delete(uuid);
        return new ResponseEntity<>(bool,HttpStatus.OK);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<Product> updateProduct(@PathVariable String uuid, @RequestBody Product product){
        return productService.updateProduct(uuid, product).map(newProduct -> new ResponseEntity<>(newProduct,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
