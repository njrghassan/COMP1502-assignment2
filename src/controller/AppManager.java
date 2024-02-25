package controller;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


import view.AppMenu;
import model.*;



public class AppManager {

    AppMenu menu = new AppMenu();
    ArrayList<Toys> toys;

    public AppManager() throws IOException{
        toys = new ArrayList<Toys>();
        loadFiles();
        displayMenuMethod();
    }

    public void displayMenuMethod() throws IOException{
        menu.displayMenu();
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        switch (option){
            case 1:
                searchInventory();
                break;
            case 2:
                //addNewToy();
                break;
            case 3:
                //removeToy();
                break;
            case 4:
                save();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public void searchInventory() throws IOException{
        menu.displaySearchMenu();
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        switch (option){
            case 1:
                searchBySerialNumber();
                break;
            case 2:
                //searchByToyName();
                break;
            case 3:
                //searchByToyType();
                break;
            case 4:
                displayMenuMethod();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public void searchBySerialNumber() throws IOException{
        String serialNumber = menu.promoteSerialNumberInput();
        ArrayList<Toys> foundToys = new ArrayList<Toys>();

        for (Toys toy : toys){
            if (toy.getSN().equals(serialNumber)){
                foundToys.add(toy);
            }
        }

        String purchsed = menu.searchResultPrompt(foundToys);
        if (purchsed != null){
            System.out.println("You have purchased " + purchsed);

            for (Toys toy : toys){
                if (toy.getSN().equals(purchsed)){
                    toy.setAvaiableCount(toy.getAvaiableCount() - 1);
                }
            }
            System.out.println("The Transaction is Seccessfully Terminated!");
        }
        else{
            System.out.println("You are back to the search menu");
        }

        searchInventory();
    }

    public void loadFiles() throws IOException{
        FileReader inputFile = new FileReader("res/toys.txt");
        BufferedReader data = new BufferedReader(inputFile);

        String line;
        String[] currentData;

        while ((line = data.readLine()) != null){
            currentData = line.trim().split(";");
            char SerialNumber = currentData[0].charAt(0);

            if (SerialNumber == '0' || SerialNumber == '1'){
                toys.add(new Figures(currentData[0], currentData[1], currentData[2], Double.parseDouble(currentData[3]), Integer.parseInt(currentData[4]), Integer.parseInt(currentData[5]), currentData[6]));
            }
            else if(SerialNumber == '2' || SerialNumber == '3'){
                toys.add(new Animals(currentData[0], currentData[1], currentData[2], Double.parseDouble(currentData[3]), Integer.parseInt(currentData[4]), Integer.parseInt(currentData[5]), currentData[6], currentData[7].charAt(0)));
            }
            else if (SerialNumber == '4' || SerialNumber == '5' || SerialNumber == '6'){
                toys.add(new Puzzles(currentData[0], currentData[1], currentData[2], Double.parseDouble(currentData[3]), Integer.parseInt(currentData[4]), Integer.parseInt(currentData[5]), currentData[6].charAt(0)));
            }
            else if (SerialNumber == '7' || SerialNumber == '8' || SerialNumber == '9'){
                // Getting the min and max players
                String[] playersRange = currentData[6].split("-");
                int minPlayers = Integer.parseInt(playersRange[0]);
                int maxPlayers = Integer.parseInt(playersRange[1]);

                // Getting the designers
                String[] designers;
                if (currentData[7].contains(",")){
                    designers = currentData[7].split(",");
                }
                else{
                    designers = new String[1];
                    designers[0] = currentData[7];
                }
                
                toys.add(new BoardGames(currentData[0], currentData[1], currentData[2], Double.parseDouble(currentData[3]), Integer.parseInt(currentData[4]), Integer.parseInt(currentData[5]), minPlayers, maxPlayers, designers));
            }
            else{
                System.out.println("Invalid data");
            }
        }

        data.close();
        System.out.println(toys.size() + " toys loaded successfully.");
    }

    public void save() throws IOException{
        FileWriter fw = new FileWriter("res/toys.txt");
        PrintWriter file = new PrintWriter(fw);

        for (Toys toy : toys){
            char SerialNumber = toy.getSN().charAt(0);
            if (SerialNumber == '0' || SerialNumber == '1'){
                file.println(toy.getSN() + ";" + toy.getName() + ";" + toy.getBrand() + ";" + toy.getPrice() + ";" + toy.getAvaiableCount() + ";" + toy.getAgeAppropriate() + ";" + ((Figures) toy).getClassification());
            }
            else if(SerialNumber == '2' || SerialNumber == '3'){
                file.println(toy.getSN() + ";" + toy.getName() + ";" + toy.getBrand() + ";" + toy.getPrice() + ";" + toy.getAvaiableCount() + ";" + toy.getAgeAppropriate() + ";" + ((Animals) toy).getMaterial() + ";" + ((Animals) toy).getSize());
            }
            else if (SerialNumber == '4' || SerialNumber == '5' || SerialNumber == '6'){
                file.println(toy.getSN() + ";" + toy.getName() + ";" + toy.getBrand() + ";" + toy.getPrice() + ";" + toy.getAvaiableCount() + ";" + toy.getAgeAppropriate() + ";" + ((Puzzles) toy).getType());
            }
            else if (SerialNumber == '7' || SerialNumber == '8' || SerialNumber == '9'){
                String designers = "";
                for (String designer : ((BoardGames) toy).getDesigners()){
                    designers += designer + ",";
                }
                designers = designers.substring(0, designers.length() - 1);
                file.println(toy.getSN() + ";" + toy.getName() + ";" + toy.getBrand() + ";" + toy.getPrice() + ";" + toy.getAvaiableCount() + ";" + toy.getAgeAppropriate() + ";" + ((BoardGames) toy).getMinPlayers() + "-" + ((BoardGames) toy).getMaxPlayers() + ";" + designers);
            }
            else{
                System.out.println("Invalid data");
            }
        }

        file.close();
        System.out.println("Data saved successfully.");
    }
}
