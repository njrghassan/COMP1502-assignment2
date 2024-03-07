package view;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import model.Toys;

public class AppMenu {

    // This is the scanner object
    Scanner input = new Scanner(System.in);

    // This method displays the main menu
    public void displayMenu() {
        String welcome =    "*******************************************************************\n" +
				            "*\t\tWELCOME TO TOY STORE COMPANY!\t\t  \t  *\n" +
				            "*******************************************************************\n";

        System.out.println(welcome);
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

    public String[] displayGiftSuggestion (){
        // This method prompts the user to enter the age, type, minimum price and maximum price of the child
        String[] giftSuggestion = new String[4]; // age, type, minPrice, maxPrice

        System.out.println("Fill some information to get a gift suggestion\nNote: you can leave 2 fields empty");

        // Child age
        System.out.println("Enter the age of the child: ");
        String age = input.nextLine();

        // Toy type
        System.out.println("Enter the type of the toy: ");
        String type = input.nextLine();
        type.toLowerCase();

        // Minimum price
        System.out.println("Enter the minimum price: ");
        String minPrice = input.nextLine();
        

        // Maximum price
        System.out.println("Enter the maximum price: ");
        String maxPrice = input.nextLine();

        if (Integer.parseInt(age) == 0 && type.equals("") && Integer.parseInt(minPrice) == 0 && Integer.parseInt(maxPrice) == 0){
            System.out.println("You have to fill at least 2 fields");
        }
        else {
            giftSuggestion[0] = age;
            giftSuggestion[1] = type;
            giftSuggestion[2] = minPrice;
            giftSuggestion[3] = maxPrice;
        }

        return giftSuggestion;
    }
}
