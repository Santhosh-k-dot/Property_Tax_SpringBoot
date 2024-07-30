package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.model.PropertyTax;
import com.example.service.PropertyTaxService;

@Controller
public class PropertyTaxController {

    @Autowired
    private PropertyTaxService propertyTaxService;

    @GetMapping("/")
    public String showCalculatorForm(Model model) {
        model.addAttribute("propertyTax", new PropertyTax());
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculateTax(@ModelAttribute PropertyTax propertyTax, Model model) {
        PropertyTax taxRates = propertyTaxService.getPropertyTaxByState(propertyTax.getState());
        if (taxRates == null) {
            model.addAttribute("error", "No tax rates found for the selected state");
            return "calculator";
        }
        model.addAttribute("taxRates", taxRates);
        model.addAttribute("propertyTax", propertyTax);

        double purchasePrice = propertyTax.getPurchasePrice(); // Correct method name
        double taxRate = propertyTax.getPropertyType().equals("residential") ? taxRates.getResidentialRate() : taxRates.getCommercialRate();
        double stampDuty = propertyTax.isMale() ? taxRates.getStampDutyMale() : taxRates.getStampDutyFemale();
        double registrationFee = taxRates.getRegistrationFee();
        double tds = taxRates.getTds();
        double gst = taxRates.getGst();

        double taxToPay = purchasePrice * taxRate;
        double stampDutyAmount = purchasePrice * stampDuty;
        double registrationFeeAmount = purchasePrice * registrationFee;
        double tdsAmount = purchasePrice * tds;
        double gstAmount = purchasePrice * gst;
        double totalPriceIncTax = purchasePrice + taxToPay + stampDutyAmount + registrationFeeAmount + tdsAmount + gstAmount;

        model.addAttribute("taxToPay", taxToPay);
        model.addAttribute("stampDutyAmount", stampDutyAmount);
        model.addAttribute("registrationFeeAmount", registrationFeeAmount);
        model.addAttribute("tdsAmount", tdsAmount);
        model.addAttribute("gstAmount", gstAmount);
        model.addAttribute("totalPriceIncTax", totalPriceIncTax);

        return "result";
    }
}
