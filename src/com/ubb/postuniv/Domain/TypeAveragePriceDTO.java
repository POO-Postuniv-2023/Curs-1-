package com.ubb.postuniv.Domain;

public class TypeAveragePriceDTO {
    public String type;
    public float averagePrice;

    public TypeAveragePriceDTO(String type, float averagePrice) {
        this.type = type;
        this.averagePrice = averagePrice;
    }

    @Override
    public String toString() {
        return "TypeAveragePriceDTO{" +
                "type='" + type + '\'' +
                ", averagePrice=" + averagePrice +
                '}';
    }
}
