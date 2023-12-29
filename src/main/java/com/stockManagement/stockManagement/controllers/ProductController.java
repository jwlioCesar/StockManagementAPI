package com.stockManagement.stockManagement.controllers;

import com.stockManagement.stockManagement.dto.request.ProductChangeRequestDto;
import com.stockManagement.stockManagement.dto.request.ProductEntryRequestDto;
import com.stockManagement.stockManagement.dto.request.ProductOutputRequestDto;
import com.stockManagement.stockManagement.dto.request.ProductRegisterRequestDto;
import com.stockManagement.stockManagement.dto.response.ProductChangeResponseDto;
import com.stockManagement.stockManagement.dto.response.ProductEntryResponseDto;
import com.stockManagement.stockManagement.dto.response.ProductOutputResponseDto;
import com.stockManagement.stockManagement.dto.response.ProductRegisterResponseDto;
import com.stockManagement.stockManagement.entities.Product;
import com.stockManagement.stockManagement.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findProducts(){
        return ResponseEntity.ok().body(productService.findAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findProductById(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductRegisterResponseDto> postProduct(@RequestBody ProductRegisterRequestDto product){
        return ResponseEntity.ok().body(productService.addProduct(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<ProductChangeResponseDto> changeProduct(@RequestBody ProductChangeRequestDto request){
        return ResponseEntity.ok().body(productService.updateProduct(request));
    }

    @PutMapping("/entry")
    public ResponseEntity<ProductEntryResponseDto> productEntry(@RequestBody ProductEntryRequestDto request){
        return ResponseEntity.ok().body(productService.productEntry(request));
    }

    @PutMapping("/output")
    public ResponseEntity<ProductOutputResponseDto> productOutput(@RequestBody ProductOutputRequestDto request){
        return ResponseEntity.ok().body(productService.productOutput(request));
    }
}
