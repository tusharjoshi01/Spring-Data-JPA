package com.JPA04.Controller;

import com.JPA04.entity.ProductEntity;
import com.JPA04.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final int Page_Size =5;
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
//this is our own method of ordering item by price
    @GetMapping
    public List<ProductEntity> getAllProducts(){
     return productRepository.findByOrderByPrice();
    }

//    this is Sort which is in-built function it provides us multiple methods like asc|desc or and fields
@GetMapping("sort")
    public List<ProductEntity> getSortedProducts(@RequestParam(defaultValue = "id") String sortBy){
//        here if two items get same then we can sort them on price we can chain this if price get similar then we can sort them on any other property
//     productRepository.findBy(Sort.by
//             (Sort.Order.desc(sortBy),
//                     Sort.Order.asc("price")));
    return productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy));
}

//here default value must be zero if you entered 1 then it will show item from 2 page as 1 page refers to 0  1 refers to page no 2
@GetMapping("page")
    public List<ProductEntity> getProductUsingPage(
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "0") Integer pageNo){
     Pageable pageable = PageRequest.of(
             pageNo,
             Page_Size,
             Sort.by(Sort.Order.asc(sortBy)));
     return productRepository.findAll(pageable).getContent();
}

//this is more clean and simple other approach we have created a jpqa method named findByTitleContaning
@GetMapping("page1")
public List<ProductEntity> getAllProductUsingPage(@RequestParam(defaultValue = "") String title,
                                                  @RequestParam(defaultValue = "id") String sortBy,
                                                  @RequestParam(defaultValue = "0") Integer pageNo
                                               )
{
   return productRepository.findByTitleContains(title, PageRequest.of(pageNo,Page_Size,Sort.by(sortBy))
      );
}
}

