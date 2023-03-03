package com.ubb.postuniv.Service;

import com.ubb.postuniv.Domain.Part;
import com.ubb.postuniv.Repository.PartRepository;

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

    public List<Part> getAll() {
        return this.partRepository.readAll();
    }
}
