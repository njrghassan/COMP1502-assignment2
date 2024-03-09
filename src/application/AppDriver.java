package application;

import controller.AppManager;

/*
 * This class is responsible for starting the application
 * @Author: Ghassan, Akram, and Mohamed
 * @Version: 1.0
 * @Date: 2024, March 10
 */
public class AppDriver {

    /*
     * This is the entry point of the application
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        // This is the entry point of the application that displays the welcome message and starts the application
        String welcome =    "*******************************************************************\n" +
				            "*\t\tWELCOME TO TOY STORE COMPANY!\t\t  \t  *\n" +
				            "*******************************************************************\n";

        System.out.println(welcome);
        AppManager app = new AppManager();
        app.run();
    }
}
