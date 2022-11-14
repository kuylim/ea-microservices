package edu.miu.productservice.repository;

import edu.miu.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Kuylim TITH
 * Date: 11/11/2022
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
