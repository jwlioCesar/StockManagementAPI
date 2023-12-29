package com.stockManagement.stockManagement.services;

import com.stockManagement.stockManagement.dto.request.ProductChangeRequestDto;
import com.stockManagement.stockManagement.dto.request.ProductEntryRequestDto;
import com.stockManagement.stockManagement.dto.request.ProductRegisterRequestDto;
import com.stockManagement.stockManagement.dto.response.ProductChangeResponseDto;
import com.stockManagement.stockManagement.dto.response.ProductEntryResponseDto;
import com.stockManagement.stockManagement.dto.response.ProductRegisterResponseDto;
import com.stockManagement.stockManagement.entities.Product;
import com.stockManagement.stockManagement.exceptions.ProductNotFoundException;
import com.stockManagement.stockManagement.repositories.ProductRepository;
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

    public ProductChangeResponseDto updateProduct(ProductChangeRequestDto request)throws ProductNotFoundException {
           Optional<Product> productOptional = productRepository.findById(request.id());

           if (productOptional.isPresent()){
               Product product = productOptional.get();
                product.setName(request.name());
                product.setQuantity(request.quantity());
                product.setPrice(request.price());

                productRepository.save(product);
                return new ProductChangeResponseDto(product);
            }else {
                throw new ProductNotFoundException();
            }
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        try {
            if (product != null) {
                productRepository.delete(product);
            } else {
                throw new ProductNotFoundException();
            }
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    public ProductEntryResponseDto productEntry(ProductEntryRequestDto request){
        Product product = productRepository.findById(request.id()).get();
        product.setQuantity(product.getQuantity()+ request.quantity());
        return new ProductEntryResponseDto(product.getId(), product.getName(), product.getQuantity(), product.getPrice(), product.getTotalValue());
    }
}