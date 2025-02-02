package amara.ui;

import java.util.Scanner;

/**
 * User interface class that handles all of the interactions
 * between the user and {@link Amara} chatbot. All of the methods
 * and interactions are implemented with their corresponding {@code enum}
 * in {@link CommandEnum}
 */
public class Ui {
    private Scanner scanner;

    public Ui(String filePath) {
        this.scanner = new Scanner(System.in);
    }

    public void greet() {
        System.out.println("Hello I'm Amara\nWhat can I do for you?");
    }

    public void display(String string) {
        System.out.println(string);
    }

    /**
     * Prints the message in the given {@code Exception}
     * @param e
     */
    public void printExceptionMessage(Exception e) {
        String message = e.getMessage();
        System.out.println(message);
    }

    public String readLine() {
        return this.scanner.nextLine();
    }
}
