package view;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.NumberException;
import exceptions.giftSuggestionException;
import model.Toys;

/*
 * This class is responsible for displaying the menu and prompting the user for input
 * @Author: Ghassan, Akram, and Mohamed
 * @Version: 1.0
 * @Date: 2024, March 10
 */
public class AppMenu {

    // This is the scanner object
    Scanner input = new Scanner(System.in);

    // This method displays the main menu
    public void displayMenu() {
        System.out.println("How We May Help You?\n");
        System.out.println("(1)\tSearch Inventory and purchase a Toy");
        System.out.println("(2)\tAdd New Toy");
        System.out.println("(3)\tRemove Toy");
        System.out.println("(4)\tGet Gift Suggestion");
        System.out.println("(5)\tSave & Exit\n");
        System.out.println("Enter Option:");
    }

   // This method displays the search menu
    public void displaySearchMenu() {
        System.out.println("Find Toys with?\n");
        System.out.println("(1)\tSerial Number (SN)");
        System.out.println("(2)\tToy Name");
        System.out.println("(3)\tToy Type");
        System.out.println("(4)\tBack to Main Menu\n");
        System.out.println("Enter Option:");
    }

    /**
     * This method prompts the user to enter the serial number and returns the input
     * @return user input
     */
    public String promoteSerialNumberInput() {
        System.out.println("Enter Serial Number (SN):");
        return input.nextLine();
    }

    /**
     * This method prompts the user to enter the toy name and returns the input
     * @return user input
     */
    public String promoteToyNameInput() {
        System.out.println("Enter Toy Name:");
        String name = input.nextLine();

        name.toLowerCase();
        return name;
    }

    /**
     * This method prompts the user to enter the toy type and returns the input
     * @return user input
     */
    public String promoteToyTypeInput() {
        System.out.println("Enter Toy Type:");
        return input.nextLine();
    }

    /**
     * This method prompts the user to select a toy from the search results and
     * returns the SNNumber of the selected toy
     * @param foundToys
     * @return SNNumber
     */
    public String searchResultPrompt(ArrayList<Toys> foundToys){
        String SNNumber = null;
        int i;

        System.out.println("Here are the search results\n");
        // Display the search results
        for (i = 0; i < foundToys.size(); i++){
            System.out.printf("(%d)\t%s\n", i + 1, foundToys.get(i).getName());
        }
        i++;
        System.out.printf("(%d)\tBack To Search Menu\n", i);
        System.out.println("Enter option to purchase: ");

        // Prompt the user to select a toy from the search results to purchase or go back to the search menu
        String option = input.nextLine();
        if (option.equals(Integer.toString(i))){
            return null;
        }
        else {
            Toys selectedToy = foundToys.get(Integer.parseInt(option) - 1);
            SNNumber = selectedToy.getSN();
        }
        
        return SNNumber;
    }
    public void addNewToyPrompt(){
        String[] userentry;
        System.out.println("Please enter serial number: ");
        String serialInput = input.nextLine();
        String toyType = "";
        try{
            if (serialInput.charAt(0) == '0' || serialInput.charAt(0) == '1'){
                toyType = "Figures";
            }
            else if (serialInput.charAt(0) == '2' || serialInput.charAt(0) == '3'){
                toyType = "Animals";
            }
            else if (serialInput.charAt(0) == '4' || serialInput.charAt(0) == '5' || serialInput.charAt(0) == '6'){

                toyType = "Puzzles";
            }
            else if (serialInput.charAt(0) == '7' || serialInput.charAt(0) == '8' || serialInput.charAt(0) == '9'){

                toyType = "BoardGames";
            }
            else{
                throw new NumberException("Invalid serial number");
            }

        }
        catch (NumberException e){
            System.out.println(e.getMessage());
        }
        finally{
            input.close();
        }
        System.out.println("Enter Toy Brand: ");
        String toyBrandInput = input.nextLine();
        
        System.out.println("Enter Toy Price: ");
        String toyPriceInput = input.nextLine();
        double toyPrice;
        try{
            toyPrice = Double.parseDouble(toyPriceInput);
            if (toyPrice < 0 ){
                throw new NumberException("Price cannot be negative! ");
            }
        }
        catch (NumberException e){
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e){
            System.out.println("Price has to be a number");
        }
        finally{
            toyPriceInput = "0";
            input.close();
        }
        System.out.println("Enter Available counts: ");
        String availableToysInput = input.nextLine();
        int availableToys;
        try{
            availableToys = Integer.parseInt(availableToysInput);
            if (availableToys < 0){
                throw new NumberException("Available count cannot be negative");
            }
        }
        catch (NumberException e){
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e){
            System.out.println("Available toys must be a number");
        }
        finally{
            availableToysInput = "0";
            input.close();
        }
        System.out.println("Enter appropriate age: ");
        String ageInput = input.nextLine();
        int age;
        try{
            age = Integer.parseInt(ageInput);
            if (age<0){
                throw new NumberException("Age cannot be negative");
            }
        }
        catch (NumberException e){
            System.out.println(e.getMessage());
        }
        catch(NumberFormatException e){
            System.out.println("Age must be a number");
        }
        finally{
            ageInput = "0";
            input.close();
        }
    }

    /**
     * This method prompts the user to enter the serial number, name, brand, price, available count and age appropriate of the toy
     * @return toy information
     */
    public String[] displayGiftSuggestion (){
        // This method prompts the user to enter the age, type, minimum price and maximum price of the child
        String[] giftSuggestion = new String[4]; // age, type, minPrice, maxPrice

        System.out.println("Fill some information to get a gift suggestion\nNote: you can leave 2 fields empty");

        // Child age
        System.out.println("Enter the age of the child: ");
        String ageInput = input.nextLine();
        int age;
        try {
            age = Integer.parseInt(ageInput);
            if (age < 0){
                throw new giftSuggestionException("Age cannot be negative");
            }
        }
        catch (giftSuggestionException e){
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e){
            System.out.println("Age has to be a number");
        }
        finally {
            ageInput = "9";
        }
        
        // Toy type
        System.out.println("Enter the type of the toy: ");
        String type = input.nextLine();
        type.toLowerCase();

        // Minimum price
        System.out.println("Enter the minimum price: ");
        String minPriceInput = input.nextLine();
        try{
            Double minPrice = Double.parseDouble(minPriceInput);
            if (minPrice < 0){
                throw new giftSuggestionException("Price cannot be negative");
            }
        }
        catch (giftSuggestionException e){
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e){
            System.out.println("Price has to be a number");
        }
        finally {
            minPriceInput = "0";
        }

        // Maximum price
        System.out.println("Enter the maximum price: ");
        String maxPrice = input.nextLine();
        try{
            Double maxPriceInput = Double.parseDouble(maxPrice);
            if (maxPriceInput < 0){
                throw new giftSuggestionException("Price cannot be negative");
            }
        }
        catch (giftSuggestionException e){
            System.out.println(e.getMessage());
        }
        catch (NumberFormatException e){
            System.out.println("Price has to be a number");
        }
        finally {
            maxPrice = "10";
        }

        if (ageInput.isEmpty() && type.isEmpty() && minPriceInput.isEmpty() && maxPrice.isEmpty()){
            System.out.println("You have to fill at least one field");
        }
        else {
            giftSuggestion[0] = ageInput;
            giftSuggestion[1] = type;
            giftSuggestion[2] = minPriceInput;
            giftSuggestion[3] = maxPrice;
        }

        return giftSuggestion;
    }
}
