package com.JPA04.Controller;

import com.JPA04.entity.ProductEntity;
import com.JPA04.repository.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
//this is our own method of ordering item by price
    @GetMapping
    public List<ProductEntity> getAllProducts(){
     return productRepository.findByOrderByPrice();
    }

//    this is Sort which is in-built function it provides us multiple methods like asc|desc or and fields
@GetMapping
    public List<ProductEntity> getSortedProducts(@RequestParam(defaultValue = "id") String sortBy){
//     return productRepository.findByOrderByPrice();
    return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy));
}
}
