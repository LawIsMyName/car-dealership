package com.pluralsight;

import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    private void init() {
        DealershipFileManager fileManager =
                new DealershipFileManager();

        dealership = fileManager.getDealership();
    }

    public void display() {

        init();

        boolean running = true;

        while (running) {

            displayMenu();

            String command = scanner.nextLine().trim();

            switch (command) {
                case "1" -> processGetByPriceRequest();
                case "2" -> processGetByMakeModelRequest();
                case "3" -> processGetByYearRequest();
                case "4" -> processGetByColorRequest();
                case "5" -> processGetByMileageRequest();
                case "6" -> processGetByTypeRequest();
                case "7" -> processGetAllVehiclesRequest();
                case "8" -> processAddVehicleRequest();
                case "9" -> processRemoveVehicleRequest();
                case "0" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void displayMenu() {

        System.out.println();
        System.out.println("---- CAR DEALERSHIP ----");
        System.out.println("1) Find vehicles by price");
        System.out.println("2) Find vehicles by make/model");
        System.out.println("3) Find vehicles by year");
        System.out.println("4) Find vehicles by color");
        System.out.println("5) Find vehicles by mileage");
        System.out.println("6) Find vehicles by type");
        System.out.println("7) List all vehicles");
        System.out.println("8) Add a vehicle");
        System.out.println("9) Remove a vehicle");
        System.out.println("0) Exit");
        System.out.print("Enter your choice: ");
    }
}

}
