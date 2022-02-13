package fi.utu.tech.gui.javafx;
import java.util.Scanner;

import javafx.application.Application;

public class Main {
    static Class<?> chooseMain(int exercise) {
        switch (exercise) {
            case 1:
                return fi.utu.tech.gui.javafx.assignment1.MainApp1.class;
            case 2:
                return fi.utu.tech.gui.javafx.assignment2.MainApp2.class;
            case 3:
                return fi.utu.tech.gui.javafx.assignment3.MainApp3.class;
            case 4:
                return fi.utu.tech.gui.javafx.assignment4.MainApp4.class;
            case 5:
                return fi.utu.tech.gui.javafx.assignment5.MainApp5.class;
            case 6:
                return fi.utu.tech.gui.javafx.assignment6.MainApp6.class;
            case 7:
                return fi.utu.tech.gui.javafx.assignment7.MainApp7.class;
            case 8:
                return fi.utu.tech.gui.javafx.assignment8.MainApp8.class;
            default:
                return null;
        }
    }

    static String askNumber() {
        System.out.print("Enter assignment number: ");
        try (Scanner s = new Scanner(System.in)) {
            return s.nextLine();
        }
    }


    /**
     * The main() method is ignored in correctly deployed JavaFX application. main() serves only as
     * fallback in case the application can not be launched through deployment artifacts, e.g., in
     * IDEs with limited FX support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int exercise = 1; // Default if no args or env
        String env = System.getenv("exercise");
        String options = (args.length == 1) ? args[0] : env;

        if (options == null);
        else if (options.equals("ask"))
            exercise = Integer.parseInt(askNumber());
        else
            exercise = Integer.parseInt(options);

        var mainClass = chooseMain(exercise);

        if (mainClass != null)
            Application.launch(mainClass.asSubclass(Application.class), args);
        else
            System.out.println("Requested exercise is not available!");

    }
}
