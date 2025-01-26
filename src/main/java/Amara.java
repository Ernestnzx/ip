import java.io.IOException;
import java.util.ArrayList;

public class Amara {
    private ArrayList<Task> tasks;
    private Memory memory;
    private Ui ui;
    private static final String FILE_PATH = "./taskfile.txt";

    Amara() {
        this.memory = new Memory(Amara.FILE_PATH);
        this.ui = new Ui(Amara.FILE_PATH);
        try {
            this.tasks = this.memory.readList();
        } catch (IOException e) {
            this.tasks = new ArrayList<Task>();
        } catch (AmaraException e) {
            System.out.println(e.getMessage());
            this.tasks = new ArrayList<Task>();
        }
    }

    private void addToList(Task task) {
        this.tasks.add(task);
        this.ui.addToList(task, this.tasks.size());
    }

    private void markTask(int index) {
        Task task = this.tasks.get(index - 1);
        task.markTask();
        this.ui.markTask(task);
    }

    private void unmarkTask(int index) {
        Task task = this.tasks.get(index - 1);
        task.unmarkTask();
        this.ui.unmarkTask(task);
    }

    private void deleteTask(int index) {
        Task task = this.tasks.get(index - 1);
        this.tasks.remove(index - 1);
        this.ui.deleteTask(task, this.tasks.size());
    }

    private void getList() {
       this.ui.getList(this.tasks); 
    }

    public void start() {
        boolean isExit = false;
        this.ui.greet();
        while (!isExit) {
            String command = this.ui.readLine();
            String commandString = Amara.getFirstWord(command);
            String commandParams = Amara.removeFirstWord(command);
            try {
                CommandEnum commandEnum = CommandEnum.fromString(commandString);
                switch (commandEnum) {
                    case BYE:
                        this.ui.exit();
                        isExit = true;
                        return;
                    case LIST:
                        this.getList();
                        break;
                    case MARK:
                        this.markTask(Integer.parseInt(commandParams));
                        break;
                    case UNMARK:
                        this.unmarkTask(Integer.parseInt(commandParams));
                        break;
                    case TODO:
                    case DEADLINE:
                    case EVENT:
                        this.addToList(TaskFactory.getTask(commandEnum, commandParams));
                        break;
                    case DELETE:
                        this.deleteTask(Integer.parseInt(commandParams));
                        break;
                    default:
                        throw AmaraException.invalidCommand();
                }
            } catch (NumberFormatException e) {
                ui.printExceptionMessage(AmaraException.numberFormatting());
            } catch (IndexOutOfBoundsException e) {
                ui.printExceptionMessage(AmaraException.indexOutOfBounds());
            } catch (AmaraException e) {
                ui.printExceptionMessage(e);
            }
        }
        try {
            this.memory.saveList(this.tasks);
        } catch (AmaraException e) {
            System.out.println("Unable to save task list :(");
        }
    }

    private static String getFirstWord(String userInput) {
        return userInput.trim().split("\\s+")[0];
    }

    private static String removeFirstWord(String userInput) {
        return userInput.replace(getFirstWord(userInput), "").trim();
    }
}
