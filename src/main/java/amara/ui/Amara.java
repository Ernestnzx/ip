package amara.ui;

import java.io.IOException;
import java.util.ArrayList;

import amara.command.Command;
import amara.command.Parser;
import amara.exceptions.AmaraException;
import amara.storage.Storage;
import amara.task.Task;

/**
 * The main class chatbot program {@code Amara}.
 */
public class Amara {
    private static final String FILE_PATH = System.getProperty("user.dir") + "/data/taskfile.txt";
    private static final String GREETING_MESSAGE = "Hello I'm Amara\nWhat can I do for you?";
    private ArrayList<Task> tasks;
    private Storage storage;
    private Ui ui;

    /**
     * Creates a new {@code Amara} bot with a instantiated
     * {@code Task} list if a valid file format is given.
     */
    Amara(String filePath) {
        this.ui = new Ui(filePath);
        try {
            this.storage = new Storage(filePath);
            this.tasks = this.storage.readList();
        } catch (AmaraException e) {
            // The error is file formatting issues
            System.out.println(e.getMessage());
            this.tasks = new ArrayList<Task>();
        } catch (IOException e) {
            this.tasks = new ArrayList<Task>();
        }
    }

    Amara() {
        this(Amara.FILE_PATH);
    }

    /**
     * Runs the {@code Amara} chatbot.
     */
    public void start() {
        boolean isBye = false;
        this.ui.display(GREETING_MESSAGE);
        while (!isBye) {
            try {
                String commandLine = this.ui.readLine();
                Command command = Parser.parseCommand(commandLine);
                command.execute(tasks, ui, storage);
                isBye = command.isBye();
            } catch (AmaraException e) {
                ui.printExceptionMessage(e);
            }
        }
    }

    /**
     * Entry point of the application.
     */
    public static void main(String[] args) {
        new Amara(Amara.FILE_PATH).start();
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input) {
        try {
            Command command = Parser.parseCommand(input);
            return command.execute(tasks, ui, storage);
        } catch (AmaraException e) {
            return e.getMessage();
        }
    }

    public String greet() {
        return GREETING_MESSAGE;
    }
}
