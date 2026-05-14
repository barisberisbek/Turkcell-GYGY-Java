package com.turkcell.spring_starter.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.turkcell.spring_starter.dto.CreateProductRequest;
import com.turkcell.spring_starter.entity.Category;
import com.turkcell.spring_starter.entity.Product;
import com.turkcell.spring_starter.repository.ProductRepository;


@Service
public class ProductServiceImpl {
    private final ProductRepository productRepository;
    private final CategoryServiceImpl categoryServiceImpl;

    public ProductServiceImpl(ProductRepository productRepository, CategoryServiceImpl categoryServiceImpl) {
        this.productRepository = productRepository;
        this.categoryServiceImpl = categoryServiceImpl;
    }



    public void create(@RequestBody CreateProductRequest createProductRequest)
    {
        // 1. -> Eklenmek istenen ürünün kategorisi var olmalıdır.
        Category category = categoryServiceImpl.getById(createProductRequest.categoryId());

        if(category == null)
            throw new RuntimeException("Böyle bir kategori bulunamadı.");

        Product product = new Product();
        product.setName(createProductRequest.name());
        product.setDescription(createProductRequest.description());
        product.setCategory(category);

        productRepository.save(product);
    }
}
