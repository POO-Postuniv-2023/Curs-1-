package com.ubb.postuniv.Domain;

public class PartProfitabilityDTO {
    public Part part;
    public float priceOverStock;

    public PartProfitabilityDTO(Part part, float priceOverStock) {
        this.part = part;
        this.priceOverStock = priceOverStock;
    }

    @Override
    public String toString() {
        return "PartProfitabilityDTO{" +
                "part=" + part +
                ", priceOverStock=" + priceOverStock +
                '}';
    }
}
