package com.github.ivosoaresalmeida.productsapi.controller;

import com.github.ivosoaresalmeida.productsapi.model.Product;
import com.github.ivosoaresalmeida.productsapi.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        System.out.println("Product recieved: " + product.toString());

        product.setId(UUID.randomUUID().toString());
        productRepository.save(product);

        return product;
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable("id") String id){
        return productRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id){
        productRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") String id, @RequestBody Product product){
        product.setId(id);
        productRepository.save(product);
    }

    @GetMapping
    public List<Product> get(@RequestParam("name") String name){
        return productRepository.findAllByName(name);
    }
}
