package com.JPA04;

import com.JPA04.entity.ProductEntity;
import com.JPA04.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class Jpa04ApplicationTests {
@Autowired
    ProductRepository productRepository;
	@Test
	void contextLoads() {
	}
    @ Test
    void testRepository(){
        ProductEntity productEntity = ProductEntity.builder()
                .sku("pepsi")
                .title("thumsup")
                .price(BigDecimal.valueOf(20.45))
                .quantity(5)
                .build();

        ProductEntity savedProductEntity=productRepository.save(productEntity);
        System.out.println(savedProductEntity);
    }

    @Test
    void getRepository(){
        List<ProductEntity> entityList = productRepository.findByTitle("nestle_coffee");
        List<ProductEntity> entities=productRepository
                .findByCreatedAtAfter(LocalDateTime.of(2024,01,06,05,30,0));
        List<ProductEntity> entities1=productRepository.findByTitleContaining("th");
        System.out.println(entityList);
        System.out.println(entities);
        System.out.println(entities1);
    }



}
