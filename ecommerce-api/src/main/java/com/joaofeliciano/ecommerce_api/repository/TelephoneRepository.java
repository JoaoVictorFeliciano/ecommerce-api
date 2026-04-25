package com.joaofeliciano.ecommerce_api.repository;

import com.joaofeliciano.ecommerce_api.entity.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository extends JpaRepository<Telephone, Long> {
}
