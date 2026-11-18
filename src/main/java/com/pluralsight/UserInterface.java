package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();

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

    private void processGetByPriceRequest() {
        System.out.println("---- SEARCH BY PRICE ----");

        System.out.print("Enter minimum price: ");
        BigDecimal min = new BigDecimal(scanner.nextLine());

        System.out.print("Enter maximum price: ");
        BigDecimal max = new BigDecimal(scanner.nextLine());

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
        displayVehicles(vehicles);
    }

    private void processGetByMakeModelRequest() {
        System.out.println("---- SEARCH BY MAKE/MODEL ----");

        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    private void processGetByYearRequest() {
        System.out.println("---- SEARCH BY YEAR ----");

        System.out.print("Enter minimum year: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter maximum year: ");
        int max = Integer.parseInt(scanner.nextLine());

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);

        displayVehicles(vehicles);
    }

    private void processGetByColorRequest() {
        System.out.println("---- SEARCH BY COLOR ----");

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByColor(color);

        displayVehicles(vehicles);
    }

    private void processGetByMileageRequest() {
        System.out.println("---- SEARCH BY MILEAGE ----");

        System.out.print("Enter minimum mileage: ");
        int min = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter maximum mileage: ");
        int max = Integer.parseInt(scanner.nextLine());

        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);

        displayVehicles(vehicles);
    }

    private void processGetByTypeRequest() {

    }

    private void processGetAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void processAddVehicleRequest() {

    }

    private void processRemoveVehicleRequest() {

    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        System.out.println();
        System.out.println("---- VEHICLE INVENTORY ----");

        System.out.printf("%-7s %-6s %-12s %-12s %-10s %-10s %-10s %12s%n", "VIN", "YEAR", "MAKE", "MODEL", "TYPE", "COLOR", "MILEAGE", "PRICE");

        System.out.println("------------------------------------------------------------------------------------------");

        for (Vehicle vehicle : vehicles) {

            System.out.printf("%-7d %-6d %-12s %-12s %-10s %-10s %-10d $%11.2f%n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
        }

        System.out.println();
        System.out.println("Total vehicles: " + vehicles.size());
    }

}





