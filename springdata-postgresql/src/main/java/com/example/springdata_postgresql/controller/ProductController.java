package com.example.springdata_postgresql.controller;

import com.example.springdata_postgresql.model.Product;
import com.example.springdata_postgresql.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping (path = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(path = "/findByPrice")
    public @ResponseBody List<Product> findProduct(@RequestParam Double price, @RequestParam Integer page, @RequestParam Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAllByPrice(price, pageable);
    }

    @GetMapping(path = "/findByPriceSort")
    public @ResponseBody List<Product> findProductSort(@RequestParam Double price, @RequestParam Integer page, @RequestParam Integer size, String sortColumn){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortColumn).descending());
        return productRepository.findAllByPrice(price, pageable);
    }




}
