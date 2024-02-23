package application;

import controller.AppManager;
import java.io.IOException;

public class AppDriver {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to my shop!");
        AppManager app = new AppManager();
        app.loadFiles();
    }
}
