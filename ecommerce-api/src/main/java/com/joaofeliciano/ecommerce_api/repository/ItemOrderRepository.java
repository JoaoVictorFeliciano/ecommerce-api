package com.joaofeliciano.ecommerce_api.repository;

import com.joaofeliciano.ecommerce_api.entity.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder, Long> {
}
