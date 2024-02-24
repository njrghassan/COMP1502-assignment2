package controller;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
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
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        switch (option){
            case 1:
                //searchInventory();
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

            line = data.readLine();
        }

        data.close();
        System.out.println("Data loaded successfully into ArrayList<Toys> toys.");
    }

    public void save() throws IOException{
        FileWriter fw = new FileWriter("res/toys.txt");
        PrintWriter file = new PrintWriter(fw);

        for (Toys toy : toys){
            file.println(toy);
        }

        file.close();
        System.out.println("Data saved successfully.");
    }
}
