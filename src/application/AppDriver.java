package application;

import controller.AppManager;

public class AppDriver {

    /*
     * This is the entry point of the application
     * @param args
     * @return void
     */
    public static void main(String[] args) {
        // This is the entry point of the application
        String welcome =    "*******************************************************************\n" +
				            "*\t\tWELCOME TO TOY STORE COMPANY!\t\t  \t  *\n" +
				            "*******************************************************************\n";

        System.out.println(welcome);
        AppManager app = new AppManager();
        app.run();
    }
}
