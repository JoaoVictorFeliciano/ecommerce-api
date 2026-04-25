package com.joaofeliciano.ecommerce_api.repository;

import com.joaofeliciano.ecommerce_api.entity.Product;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
