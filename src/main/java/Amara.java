import java.io.IOException;
import java.util.ArrayList;

import amara.command.Command;
import amara.command.Parser;
import amara.exceptions.AmaraException;
import amara.storage.Storage;
import amara.task.Task;
import amara.ui.Ui;

public class Amara {
    private ArrayList<Task> tasks;
    private Storage storage;
    private Ui ui;
    private static final String FILE_PATH = "./taskfile.txt";

    Amara() {
        this.storage = new Storage(Amara.FILE_PATH);
        this.ui = new Ui(Amara.FILE_PATH);
        try {
            this.tasks = this.storage.readList();
        } catch (IOException e) {
            this.tasks = new ArrayList<Task>();
        } catch (AmaraException e) {
            System.out.println(e.getMessage());
            this.tasks = new ArrayList<Task>();
        }
    }

    public void start() {
        boolean isBye = false;
        this.ui.greet();
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

    public static void main(String[] args) {
        new Amara().start();
    }
}
