package com.ubb.postuniv.Service;

import com.ubb.postuniv.Domain.Part;
import com.ubb.postuniv.Domain.PartProfitabilityDTO;
import com.ubb.postuniv.Repository.PartRepository;

import java.util.ArrayList;
import java.util.List;

public class PartService {

    private PartRepository partRepository;

    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
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

    public List<Part> getAll() {
        return this.partRepository.readAll();
    }
}
