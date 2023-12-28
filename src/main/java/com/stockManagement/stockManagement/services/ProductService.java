package com.stockManagement.stockManagement.services;

import com.stockManagement.stockManagement.dto.request.ProductRegisterRequestDto;
import com.stockManagement.stockManagement.dto.response.ProductRegisterResponseDto;
import com.stockManagement.stockManagement.entities.Product;
import com.stockManagement.stockManagement.exceptions.ProductNotFoundException;
import com.stockManagement.stockManagement.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public ProductRegisterResponseDto addProduct(ProductRegisterRequestDto request) {
        Product product = new Product(request.name(), request.quantity(), request.price());
        productRepository.save(product);
        return new ProductRegisterResponseDto(product.getName(), product.getQuantity(), product.getPrice(), product.getTotalValue());
    }

    public ProductRegisterResponseDto alterProduct(ProductRegisterRequestDto request) {
        Product product = new Product(request.name(), request.quantity(), request.price());
        productRepository.save(product);
        return new ProductRegisterResponseDto(product.getName(), product.getQuantity(), product.getPrice(), product.getTotalValue());
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        try {
            if (product != null) {
                productRepository.delete(product);
            } else {
                throw new ProductNotFoundException("Produto não encontrado com o ID: " + id);
            }
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}