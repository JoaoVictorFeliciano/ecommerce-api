package com.joaofeliciano.ecommerce_api.repository;

import com.joaofeliciano.ecommerce_api.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
}
