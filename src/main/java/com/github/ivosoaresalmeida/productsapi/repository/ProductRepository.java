package com.github.ivosoaresalmeida.productsapi.repository;

import com.github.ivosoaresalmeida.productsapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findAllByName(String name);
}
