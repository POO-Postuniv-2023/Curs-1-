package com.ubb.postuniv;

import com.ubb.postuniv.Domain.PartValidator;
import com.ubb.postuniv.Repository.PartRepository;
import com.ubb.postuniv.Service.PartService;
import com.ubb.postuniv.UserInterface.Console;

public class Main {

    public static void main(String[] args) throws Exception {

        PartRepository partRepository = new PartRepository();
        PartValidator partValidator = new PartValidator();
        PartService partService = new PartService(partRepository, partValidator);

        partService.add(1, "Roata", 200, 13, "OEM");
        partService.add(2, "Capota", 400, 10, "OEM");
        partService.add(3, "Usa", 1311, 244, "AM");
        partService.add(4, "Motor", 5456, 6, "SH");
        partService.add(5, "Scaun", 764, 1392, "AM");

        Console console = new Console(partService);

        console.runConsole();
    }
}
