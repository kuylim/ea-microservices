package edu.miu.productservice.controller;

import edu.miu.productservice.entity.Product;
import edu.miu.productservice.service.ProductService;
import edu.miu.productservice.service.UserClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Author: Kuylim TITH
 * Date: 11/11/2022
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;
    private final RestTemplate restTemplate;
    private final UserClient userClient;

    @GetMapping
    public List<Product> getAllProduct() {
       // ResponseEntity<UserDTO> response = restTemplate.getForEntity("http://user-service/api/v1/users/1", UserDTO.class);
       // System.out.println(response.getBody());
        log.info("Get all products call...");
        System.out.println(userClient.getUserById(1L));
        return productService.getAllProduct();
    }
}