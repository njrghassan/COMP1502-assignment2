package controller;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


import view.AppMenu;
import model.*;

public class AppManager {

    // This is the menu object
    AppMenu menu = new AppMenu();
    // This is the toys arraylist aka our database
    ArrayList<Toys> toys;

    /**
     * This is the main method of the application
     * @throws IOException
     */
    public void run() throws IOException {
        toys = new ArrayList<Toys>();
        loadFiles();
        displayMenuMethod();
    }

    /**
     * The Main Menu method
     * This method displays the main menu and handles the user's input
     * @throws IOException
     */
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

        input.close();
    }

    /**
     * The Search Menu method
     * This method handles the search inventory option
     * @throws IOException
     */
    public void searchInventory() throws IOException{
        menu.displaySearchMenu();
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        switch (option){
            case 1:
                searchBySerialNumber();
                break;
            case 2:
                searchByToyName();
                break;
            case 3:
                searchByToyType();
                break;
            case 4:
                displayMenuMethod();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

        input.close();
    }

    /**
     * This method handles the search by serial number option
     * It prompts the user to enter a serial number and then searches the inventory for the toy with that serial number
     * If the toy is found, it prompts the user to purchase it and then updates the toy's available count
     * @throws IOException
     */
    public void searchBySerialNumber() throws IOException{
        String serialNumber = menu.promoteSerialNumberInput(); // Prompts the user to enter a serial number
        ArrayList<Toys> foundToys = new ArrayList<Toys>(); // This will store the found toys

        // Search the inventory for the toy with the given serial number
        for (Toys toy : toys){
            if (toy.getSN().equals(serialNumber)){
                foundToys.add(toy);
            }
        }

        searchProsses(foundToys);
    }

    /**
     * This method handles the search by toy name option
     * It prompts the user to enter a toy name and then searches the inventory for the toy with that name
     * If the toy is found, it prompts the user to purchase it and then updates the toy's available count
     * @throws IOException
     */
    public void searchByToyName() throws IOException{
        String toyName = menu.promoteToyNameInput(); // Prompts the user to enter a toy name
        ArrayList<Toys> foundToys = new ArrayList<Toys>(); // This will store the found toys

        // Search the inventory for the toy with the given name
        for (Toys toy : toys){
            if (toy.getName().toLowerCase().contains(toyName) && toyName.length() >= 3){
                foundToys.add(toy);
            }
        }

        searchProsses(foundToys);
    }

    public void searchByToyType() throws IOException{
        String toyType = menu.promoteToyTypeInput(); // Prompts the user to enter a toy type
        ArrayList<Toys> foundToys = new ArrayList<Toys>(); // This will store the found toys

        // Search the inventory for the toy with the given type
        for (Toys toy : toys){
            if (toy.getClass().getSimpleName().toLowerCase().contains(toyType)){
                foundToys.add(toy);
            }
        }

        searchProsses(foundToys);
    }

    /**
     * This method handles the search by toy type option
     * It prompts the user to enter a toy type and then searches the inventory for the toy with that type
     * If the toy is found, it prompts the user to purchase it and then updates the toy's available count
     * @throws IOException
     */
    public void searchProsses(ArrayList<Toys> foundToys) throws IOException{
        // If the toy is found, prompt the user to purchase it and then update the toy's available count
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

        // Go back to the search menu
        searchInventory();
    }

    /**
     * This method loads the data from the file into the arraylist
     * It reads the file and creates the toys based on the data in the file
     * while adding them to their appropriate arraylist from the parent class (toys)
     */
    public void loadFiles(){
        // File stuff
        File inputFile = new File("res/toys.txt");
        String line = "";
        String[] currentData; // This will store the current line of data from line
        
        if (inputFile.exists()){
            if (inputFile.isFile() && inputFile.canRead()){
                Scanner data = null;
                try {
                    // Read the file and create the toys
                    data = new Scanner(inputFile);
                    while (data.hasNextLine()){
                        line = data.nextLine(); // Read the line of data
                        currentData = line.trim().split(";"); // Split the line of data into an array of strings
                        char SerialNumber = currentData[0].charAt(0); // Get the serial number of the toy
                    
                        // Create the toys based on the serial number and add them to their aoopriate arraylist from the parent class (toys)
                        // Figures
                        if (SerialNumber == '0' || SerialNumber == '1'){
                            toys.add(new Figures(currentData[0], currentData[1], currentData[2], Double.parseDouble(currentData[3]), Integer.parseInt(currentData[4]), Integer.parseInt(currentData[5]), currentData[6]));
                        }
                        // Animals
                        else if(SerialNumber == '2' || SerialNumber == '3'){
                            toys.add(new Animals(currentData[0], currentData[1], currentData[2], Double.parseDouble(currentData[3]), Integer.parseInt(currentData[4]), Integer.parseInt(currentData[5]), currentData[6], currentData[7].charAt(0)));
                        }
                        // Puzzles
                        else if (SerialNumber == '4' || SerialNumber == '5' || SerialNumber == '6'){
                            toys.add(new Puzzles(currentData[0], currentData[1], currentData[2], Double.parseDouble(currentData[3]), Integer.parseInt(currentData[4]), Integer.parseInt(currentData[5]), currentData[6].charAt(0)));
                        }
                        // BoardGames
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
                                // If there is only one designer
                                designers = new String[1];
                                designers[0] = currentData[7];
                            }

                            toys.add(new BoardGames(currentData[0], currentData[1], currentData[2], Double.parseDouble(currentData[3]), Integer.parseInt(currentData[4]), Integer.parseInt(currentData[5]), minPlayers, maxPlayers, designers));
                        }
                        else{
                            System.out.println("Invalid data in the file.");
                        }
                    }
                } 
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                finally{
                    data.close();
                }
            }
        }

        System.out.println(toys.size() + " toys loaded successfully.");
    }

    /**
     * This method saves the data from the arraylist into the file
     * It writes the data to the file based on the type of the toy
     */
    public void save(){
        // File stuff
        File fw = new File("res/toys.txt");

        if (fw.exists()){
            if (fw.isFile() && fw.canWrite()){
                System.out.println("Saving Data Into Database...");
                PrintWriter file = null;
                try {
                    file = new PrintWriter(fw);
                    // Write the data to the file
                    for (Toys toy : toys){
                        char SerialNumber = toy.getSN().charAt(0); // Get the serial number of the toy
                    
                        // Save the toys based on the serial number to the file. Each toy has a different number of attributes
                        // Figures
                        if (SerialNumber == '0' || SerialNumber == '1'){
                            file.println(toy.getSN() + ";" + toy.getName() + ";" + toy.getBrand() + ";" + toy.getPrice() + ";" + toy.getAvaiableCount() + ";" + toy.getAgeAppropriate() + ";" + ((Figures) toy).getClassification());
                        }
                        // Animals
                        else if(SerialNumber == '2' || SerialNumber == '3'){
                            file.println(toy.getSN() + ";" + toy.getName() + ";" + toy.getBrand() + ";" + toy.getPrice() + ";" + toy.getAvaiableCount() + ";" + toy.getAgeAppropriate() + ";" + ((Animals) toy).getMaterial() + ";" + ((Animals) toy).getSize());
                        }
                        // Puzzles
                        else if (SerialNumber == '4' || SerialNumber == '5' || SerialNumber == '6'){
                            file.println(toy.getSN() + ";" + toy.getName() + ";" + toy.getBrand() + ";" + toy.getPrice() + ";" + toy.getAvaiableCount() + ";" + toy.getAgeAppropriate() + ";" + ((Puzzles) toy).getType());
                        }
                        // BoardGames
                        else if (SerialNumber == '7' || SerialNumber == '8' || SerialNumber == '9'){
                            // Getting the designers
                            String designers = "";
                            for (String designer : ((BoardGames) toy).getDesigners()){
                                designers += designer + ",";
                            }
                            // Remove the last comma
                            designers = designers.substring(0, designers.length() - 1);
                            file.println(toy.getSN() + ";" + toy.getName() + ";" + toy.getBrand() + ";" + toy.getPrice() + ";" + toy.getAvaiableCount() + ";" + toy.getAgeAppropriate() + ";" + ((BoardGames) toy).getMinPlayers() + "-" + ((BoardGames) toy).getMaxPlayers() + ";" + designers);
                        }
                        else{
                            System.out.println("Invalid data");
                        }
                    }
                } 
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                finally{
                    file.close();
                }
            }
        }

        System.out.println("******* THANKS FOR VISITTING US *******");
    }
}
