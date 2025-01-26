import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Amara {
    private ArrayList<Task> tasks;
    private Memory memory;
    private Scanner scanner;
    private Ui ui;

    private static final String BOARDER = "=".repeat(70);

    Amara() {
        this.memory = new Memory();
        this.scanner = new Scanner(System.in);
        this.ui = new Ui();
        try {
            this.tasks = this.memory.readList();
        } catch (IOException e) {
            this.tasks = new ArrayList<Task>();
        } catch (AmaraException e) {
            System.out.println(e.getMessage());
            this.tasks = new ArrayList<Task>();
        }
    }

    private String wrapText(String text) {
        return String.format("%s\n%s\n%s", Amara.BOARDER, text, Amara.BOARDER);
    }

    @SuppressWarnings("unused")
    private String echo(String sentence) {
        return sentence;
    }

    private String addToList(Task task) {
        this.tasks.add(task);
        return String.format("Got it. I've added this task:\n"
                + "  %s\nNow you have %d tasks in the list.", task, this.tasks.size());
    }

    private String markTask(int index) {
        Task task = this.tasks.get(index - 1);
        task.markTask();
        return String.format("Nice! I've marked this task as done:\n  %s", task);
    }

    private String unmarkTask(int index) {
        Task task = this.tasks.get(index - 1);
        task.unmarkTask();
        return String.format("OK, I've marked this task as not done yet:\n  %s", task);
    }

    private String deleteTask(int index) {
        Task task = this.tasks.get(index - 1);
        this.tasks.remove(index - 1);
        return String.format("Noted. I've removed this task:\n"
                + "  %s\nNow you have %d tasks in the list.", task, this.tasks.size());
    }

    private String getList() {
        // Using StringBuilder if speed is needed.
        String taskList = "Here are the tasks in your list:\n";
        int listSize = this.tasks.size();
        if (listSize == 0) {
            taskList += "<You have no tasks, you may rest for now...>";
        }
        for (int i = 0; i < listSize; i++) {
            taskList += i + 1 + ". " + tasks.get(i);
            if (i < listSize - 1) {
                taskList += "\n";
            }
        }
        return taskList;
    }

    public void start() {
        boolean isExit = false;
        this.ui.greet();
        while (!isExit) {
            String reply = "";
            String command = this.scanner.nextLine();
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
                        reply = this.getList();
                        break;
                    case MARK:
                        reply = this.markTask(Integer.parseInt(commandParams));
                        break;
                    case UNMARK:
                        reply = this.unmarkTask(Integer.parseInt(commandParams));
                        break;
                    case TODO:
                    case DEADLINE:
                    case EVENT:
                        reply = this.addToList(TaskFactory.getTask(commandEnum, commandParams));
                        break;
                    case DELETE:
                        reply = this.deleteTask(Integer.parseInt(commandParams));
                        break;
                    default:
                        throw AmaraException.invalidCommand();
                }
            } catch (NumberFormatException e) {
                reply = AmaraException.numberFormatting().getMessage();
            } catch (IndexOutOfBoundsException e) {
                reply = AmaraException.indexOutOfBounds().getMessage();
            } catch (AmaraException e) {
                reply = e.getMessage();
            }
            System.out.println(this.wrapText(reply));
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
