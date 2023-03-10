package com.ubb.postuniv.Service;

import com.ubb.postuniv.Domain.Part;
import com.ubb.postuniv.Domain.PartProfitabilityDTO;
import com.ubb.postuniv.Domain.PartValidator;
import com.ubb.postuniv.Domain.TypeAveragePriceDTO;
import com.ubb.postuniv.Repository.PartRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartService {

    private PartRepository partRepository;
    private PartValidator partValidator;

    public PartService(PartRepository partRepository, PartValidator partValidator) {
        this.partRepository = partRepository;
        this.partValidator = partValidator;
    }

    /**
     * ...
     * @param id
     * @param name
     * @param price
     * @param stock
     * @param type
     * @throws Exception
     */
    public void add(int id, String name, float price, int stock, String type) throws Exception {
        Part part = new Part(id, name, price, stock, type);
        this.partValidator.validate(part);
        this.partRepository.create(part);
    }

    public List<PartProfitabilityDTO> getPartsSortedByProfitability() {
        List<Part> allParts = this.getAll();
        List<PartProfitabilityDTO> result = new ArrayList<>();
        for (Part p:
             allParts) {
            result.add(new PartProfitabilityDTO(p, p.getPrice() / p.getStock()));
        }

        for (int i = 0; i < result.size(); ++i) {
            for (int j = i+1; j < result.size(); ++j) {
                if (result.get(i).priceOverStock < result.get(j).priceOverStock) {
                    PartProfitabilityDTO t = result.get(i);
                    result.set(i, result.get(j));
                    result.set(j, t);
                }
            }
        }

        return result;
    }

    public List<TypeAveragePriceDTO> getTypesWithAveragePrices() {
        Map<String, List<Float>> typesPrices = new HashMap<>();
        for (Part p: this.getAll()) {
            String type = p.getType();
            float price = p.getPrice();
            if (!typesPrices.containsKey(type)) {
                typesPrices.put(type, new ArrayList<>());
            }
            typesPrices.get(type).add(price);
        }

        List<TypeAveragePriceDTO> result = new ArrayList<>();
        for (String type : typesPrices.keySet()) {
            float average = 0;
            for (float price : typesPrices.get(type)) {
                average += price;
            }
            average /= typesPrices.get(type).size();

            result.add(new TypeAveragePriceDTO(type, average));
        }

        result.sort((a, b) -> {
            float difference = a.averagePrice - b.averagePrice;
            System.out.printf("a.avg=%f, b.avg=%f, difference=%f\n", a.averagePrice, b.averagePrice, difference);
            float eps = 0.00001f;
            if (Math.abs(difference) < eps) {
                return 0;
            }

//            if (difference < -eps) {
//                return 1;
//            } else {
//                return -1;
//            }

            // operator ternar
            return difference < -eps ? 1 : -1;
        });

        return result;
    }

    public List<Part> getAll() {
        return this.partRepository.readAll();
    }
}
