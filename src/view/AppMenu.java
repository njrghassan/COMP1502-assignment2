package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Toys;

public class AppMenu {

    Scanner input = new Scanner(System.in);

    public void displayMenu() {
        String welcome =   "*******************************************************************\n" +
				            "*\t\tWELCOME TO TOY STORE COMPANY!\t\t  \t  *\n" +
				            "*******************************************************************\n";

        System.out.println(welcome);
        System.out.println("How We May Help You?\n");
        System.out.println("(1)\tSearch Inventory and purchase a Toy");
        System.out.println("(2)\tAdd New Toy");
        System.out.println("(3)\tRemove Toy");
        System.out.println("(4)\tSave & Exit\n");
        System.out.println("Enter Option:");
    }

    public void displaySearchMenu() {
        System.out.println("Find Toys with?\n");
        System.out.println("(1)\tSerial Number (SN)");
        System.out.println("(2)\tToy Name");
        System.out.println("(3)\tToy Type");
        System.out.println("(4)\tBack to Main Menu\n");
        System.out.println("Enter Option:");
    }

    public String promoteSerialNumberInput() {
        System.out.println("Enter Serial Number (SN):");
        return input.nextLine();
    }

    public String promoteToyNameInput() {
        System.out.println("Enter Toy Name:");
        return input.nextLine();
    }

    public String promoteToyTypeInput() {
        System.out.println("Enter Toy Type:");
        return input.nextLine();
    }

    public String searchResultPrompt(ArrayList<Toys> foundToys){
        String SNNumber = null;
        int i;

        System.out.println("Here are the search results\n");
        for (i = 0; i < foundToys.size(); i++){
            System.out.printf("(%d)\t%s\n", i + 1, foundToys.get(i).getName());
        }
        i++;
        System.out.printf("(%d)\tBack To Search Menu\n", i);
        System.out.println("Enter option to purchase: ");

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
}
