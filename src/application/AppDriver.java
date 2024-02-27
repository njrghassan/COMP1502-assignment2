package application;

import controller.AppManager;
import java.io.IOException;

public class AppDriver {

    /**
     * This is the main method of the application
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // This is the entry point of the application
        AppManager app = new AppManager();
        app.run();
    }
}
