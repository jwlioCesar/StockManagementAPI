package com.stockManagement.stockManagement.services;

import com.stockManagement.stockManagement.dto.request.ProductRegisterRequestDto;
import com.stockManagement.stockManagement.dto.response.ProductRegisterResponseDto;
import com.stockManagement.stockManagement.entities.Product;
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

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id){
       return productRepository.findById(id);
    }

    public ProductRegisterResponseDto addProduct(ProductRegisterRequestDto request){
        Product product = new Product(request.name(), request.quantity(), request.price());
        productRepository.save(product);
        return new ProductRegisterResponseDto(product.getName(), product.getQuantity(), product.getPrice(), product.getTotalValue());
    }

    public ProductRegisterResponseDto alterProduct(ProductRegisterRequestDto request){
        Product product = new Product(request.name(), request.quantity(), request.price());
        productRepository.save(product);
        return new ProductRegisterResponseDto(product.getName(), product.getQuantity(), product.getPrice(), product.getTotalValue());
    }

    public String deleteProduct(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            productRepository.delete(product);
            return "Produto removido com sucesso";
        } else {
            return "Produto não encontrado";
        }
    }



}
