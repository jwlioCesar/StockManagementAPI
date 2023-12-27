package com.stockManagement.stockManagement.repositories;

import com.stockManagement.stockManagement.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
