package com.ubb.postuniv_tests;

import com.ubb.postuniv.Domain.Part;
import com.ubb.postuniv.Repository.PartRepository;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PartRepositoryTest {

    @org.junit.jupiter.api.Test
    void validAdds_should_saveToRepository() throws Exception {

        // AAA - Arrange, Act, Assert

        // Arrange
        PartRepository partRepository = new PartRepository();
        Part p1 = new Part(1, "p1", 100, 10, "SH");
        Part p2 = new Part(2, "p2", 120, 12, "SH");
        Part p3 = new Part(3, "p3", 100, 16, "AM");
        Part p4 = new Part(4, "p1", 170, 10, "OEM");

        // Act
        partRepository.create(p1);
        partRepository.create(p2);
        partRepository.create(p3);
        partRepository.create(p4);

        // Assert
        List<Part> allParts = partRepository.readAll();
        Assertions.assertEquals(4, allParts.size());
        Assertions.assertNotNull(partRepository.readOne(1));
    }

    @org.junit.jupiter.api.Test
    void addsWithDuplicateId_should_raiseExceptionInRepository() throws Exception {
        PartRepository partRepository = new PartRepository();
        Part p1 = new Part(1, "p1", 100, 10, "SH");
        Part p2 = new Part(2, "p2", 120, 12, "SH");
        Part p3 = new Part(1, "p3", 100, 16, "AM");

        partRepository.create(p1);
        partRepository.create(p2);

        try {
            partRepository.create(p3);
            Assertions.fail("Exception not raised in repository for duplicate id");
        } catch (Exception ex) {

        }
    }

    @org.junit.jupiter.api.Test
    void getTypesWithAveragePrices() {
    }

    @org.junit.jupiter.api.Test
    void getAll() {
    }
}