package com.ubb.postuniv.Repository;

import com.ubb.postuniv.Domain.Part;
import org.xml.sax.helpers.AttributeListImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartRepository {
    private Map<Integer, Part> storage = new HashMap<>();

    public PartRepository() {

    }

    /**
     * Add a Part object to the repository.
     * @param part the Part object to add, the ID must be unique.
     * @throws Exception if the ID exists.
     */
    public void create(Part part) throws Exception {
        if (this.storage.containsKey(part.getId())) {
            throw new Exception("There is already a part with the id: " + part.getId());
        }
        this.storage.put(part.getId(), part);
    }

    /**
     * Gets a list of all parts.
     * @return a list with all Part objects.
     */
    public List<Part> readAll() {
        return new ArrayList<>(this.storage.values());
    }

    public Part readOne(int id) {
        return this.storage.get(id);
    }

    public void update(Part part) throws Exception {
        if (!this.storage.containsKey(part.getId())) {
            throw new Exception("There is no part with the id: " + part.getId() + " to update.");
        }
        this.storage.put(part.getId(), part);
    }

    public void delete(int id) throws Exception {
        if (!this.storage.containsKey(id)) {
            throw new Exception("There is no part with the id: " + id + " to delete.");
        }
        this.storage.remove(id);
    }
}
