import java.util.ArrayList;
import java.util.Scanner;

public class Amara {
    private ArrayList<Task> tasks;
    private Scanner scanner;

    private static final String BOARDER = "=".repeat(70);

    Amara() {
        this.tasks = new ArrayList<Task>();
        this.scanner = new Scanner(System.in);
    }

    private String wrapText(String text) {
        return String.format("%s\n%s\n%s", Amara.BOARDER, text, Amara.BOARDER);
    }

    private String greet() {
        return "Hello I'm Amara\nWhat can I do for you?";
    }

    private String exit() {
        return "Bye. Hope to see you again soon! <3";
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
        System.out.println(this.wrapText(this.greet()));
        while (!isExit) {
            String reply = "";
            String command = this.scanner.nextLine();
            // System.out.println(command);
            String commandString = Amara.getFirstWord(command);
            String commandParams = Amara.removeFirstWord(command);
            try {
                Command commandEnum = Command.fromString(commandString);
                switch (commandEnum) {
                    case BYE:
                        reply = this.exit();
                        isExit = true;
                        break;
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
                        reply = this.addToList(TaskFactory.getTask(commandString, commandParams));
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
    }

    private static String getFirstWord(String userInput) {
        return userInput.trim().split("\\s+")[0];
    }

    private static String removeFirstWord(String userInput) {
        return userInput.replace(getFirstWord(userInput), "").trim();
    }
}
