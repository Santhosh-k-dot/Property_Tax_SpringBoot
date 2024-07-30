package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.model.PropertyTax;

public interface PropertyTaxRepository extends JpaRepository<PropertyTax, Long> {
    PropertyTax findByState(String state);
}
