package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Toys;


public class AppManager {

    ArrayList<Toys> toys;

    public void loadFiles() throws IOException{
        FileReader inputFile = new FileReader("res/toys.txt");
        BufferedReader data = new BufferedReader(inputFile);

        String line = data.readLine();
        String[] currentData;

        while (line != null){
            currentData = line.trim().split(":");
            toys.add(new Toys(currentData[0], currentData[1], currentData[2], Double.parseDouble(currentData[3]), Integer.parseInt(currentData[4]), Integer.parseInt(currentData[5])));
            line = data.readLine();
        }

        data.close();

        for (Toys toy : toys){
            System.out.println(toy.getSN() + " " + toy.getName() + " " + toy.getBrand() + " " + toy.getPrice() + " " + toy.getAvaiableCount() + " " + toy.getAgeAppropriate());
        }
    }
}
