package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PropertyTax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String state;
    private double residentialRate;
    private double commercialRate;
    private double stampDutyMale;
    private double stampDutyFemale;
    private double registrationFee;
    private double tds;
    private double gst;
    private Double purchasePrice; // Use Double instead of double
    private String propertyType;
    private boolean isMale;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getResidentialRate() {
        return residentialRate;
    }

    public void setResidentialRate(double residentialRate) {
        this.residentialRate = residentialRate;
    }

    public double getCommercialRate() {
        return commercialRate;
    }

    public void setCommercialRate(double commercialRate) {
        this.commercialRate = commercialRate;
    }

    public double getStampDutyMale() {
        return stampDutyMale;
    }

    public void setStampDutyMale(double stampDutyMale) {
        this.stampDutyMale = stampDutyMale;
    }

    public double getStampDutyFemale() {
        return stampDutyFemale;
    }

    public void setStampDutyFemale(double stampDutyFemale) {
        this.stampDutyFemale = stampDutyFemale;
    }

    public double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(double registrationFee) {
        this.registrationFee = registrationFee;
    }

    public double getTds() {
        return tds;
    }

    public void setTds(double tds) {
        this.tds = tds;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public Double getPurchasePrice() { // Use Double instead of double
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) { // Use Double instead of double
        this.purchasePrice = purchasePrice;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean isMale) {
        this.isMale = isMale;
    }
}
