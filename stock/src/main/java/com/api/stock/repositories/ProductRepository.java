package com.api.stock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.stock.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
