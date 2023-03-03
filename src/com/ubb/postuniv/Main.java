package com.ubb.postuniv;

import com.ubb.postuniv.Repository.PartRepository;
import com.ubb.postuniv.Service.PartService;
import com.ubb.postuniv.UserInterface.Console;

public class Main {

    public static void main(String[] args) {

        PartRepository partRepository = new PartRepository();
        PartService partService = new PartService(partRepository);
        Console console = new Console(partService);

        console.runConsole();
    }
}
