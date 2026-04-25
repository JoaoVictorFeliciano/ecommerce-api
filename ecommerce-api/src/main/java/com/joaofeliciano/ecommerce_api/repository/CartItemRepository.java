package com.joaofeliciano.ecommerce_api.repository;

import com.joaofeliciano.ecommerce_api.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
