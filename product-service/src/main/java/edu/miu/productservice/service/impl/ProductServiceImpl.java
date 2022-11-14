package edu.miu.productservice.service.impl;

import edu.miu.productservice.entity.Product;
import edu.miu.productservice.repository.ProductRepository;
import edu.miu.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/11/2022
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public List<Product> getAllProduct() {
        return repository.findAll();
    }
}
