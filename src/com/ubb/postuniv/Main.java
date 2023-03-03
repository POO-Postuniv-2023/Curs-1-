package com.ubb.postuniv;

import com.ubb.postuniv.Repository.PartRepository;
import com.ubb.postuniv.Service.PartService;
import com.ubb.postuniv.UserInterface.Console;

public class Main {

    public static void main(String[] args) throws Exception {

        PartRepository partRepository = new PartRepository();
        PartService partService = new PartService(partRepository);

        partService.add(1, "Roata", 200, 13, "A");
        partService.add(2, "Capota", 400, 10, "A");
        partService.add(3, "Usa", 1311, 244, "B");
        partService.add(4, "Motor", 5456, 6, "C");
        partService.add(5, "Scaun", 764, 1392, "B");

        Console console = new Console(partService);

        console.runConsole();
    }
}
