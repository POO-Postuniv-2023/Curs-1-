package com.ubb.postuniv.UserInterface;

import com.ubb.postuniv.Domain.Part;
import com.ubb.postuniv.Domain.PartProfitabilityDTO;
import com.ubb.postuniv.Service.PartService;

import java.awt.*;
import java.util.Scanner;

public class Console {

    private PartService partService;
    private Scanner scanner;

    public Console(PartService partService) {
        this.partService = partService;
        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Add a part");
        System.out.println("2. Show parts");
        System.out.println("3. Show profitability report");

        System.out.println("0. Exit");
        System.out.println("Enter your option: ");
    }

    private void handleAddPart() {
        try {
            System.out.print("Enter the id: ");
            int id = scanner.nextInt();

            System.out.print("Enter the name: ");
            String name = scanner.next();

            System.out.print("Enter the price: ");
            float price = scanner.nextFloat();

            System.out.print("Enter the stock: ");
            int stock = scanner.nextInt();

            System.out.print("Enter the type: ");
            String type = scanner.next();

            this.partService.add(id, name, price, stock, type);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void handleShowAll() {
        for (Part p:
             this.partService.getAll()) {
            System.out.println(p);
        }
    }

    private void handleProfitabilityReport() {
        for (PartProfitabilityDTO p:
                this.partService.getPartsSortedByProfitability()) {
            System.out.println(p);
        }
    }

    public void runConsole() {
        while (true) {
            this.showMenu();
            int option = this.scanner.nextInt();
            switch (option) {
                case 1:
                    this.handleAddPart();
                    break;
                case 2:
                    this.handleShowAll();
                    break;
                case 3:
                    this.handleProfitabilityReport();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Unsupported command.");
            }
        }
    }
}
