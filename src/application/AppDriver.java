package application;

import controller.AppManager;
import exceptions.menusInputsExceptions;

public class AppDriver {

    /**
     * This is the main method of the application
     * @param args
     * @throws menusInputsExceptions
     */
    public static void main(String[] args) throws menusInputsExceptions {
        // This is the entry point of the application
        String welcome =    "*******************************************************************\n" +
				            "*\t\tWELCOME TO TOY STORE COMPANY!\t\t  \t  *\n" +
				            "*******************************************************************\n";

        System.out.println(welcome);
        AppManager app = new AppManager();
        app.run();
    }
}
