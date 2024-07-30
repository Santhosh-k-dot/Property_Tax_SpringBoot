package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.PropertyTax;
import com.example.repository.PropertyTaxRepository;

@Service
public class PropertyTaxService {

    @Autowired
    private PropertyTaxRepository propertyTaxRepository;

    public PropertyTax getPropertyTaxByState(String state) {
        return propertyTaxRepository.findByState(state);
    }
}
