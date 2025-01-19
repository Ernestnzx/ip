import java.util.ArrayList;
import java.util.Scanner;

public class Amara {
    private ArrayList<Task> tasks;
    private Scanner scanner;

    private static final String BOARDER = "=".repeat(60);

    Amara() {
        this.tasks = new ArrayList<Task>();
        this.scanner = new Scanner(System.in);
    }

    private String wrapText(String text) {
        return String.format("%s\n%s\n%s", Amara.BOARDER, text, Amara.BOARDER);
    }

    private String greet() {
        return this.wrapText("Hello I'm Amara\nWhat can I do for you?");
    }

    private String exit() {
        return this.wrapText("Bye. Hope to see you again soon! <3");
    }

    @SuppressWarnings("unused")
    private String echo(String sentence) {
        return this.wrapText(sentence);
    }

    private String addToList(Task task) {
        this.tasks.add(task);
        return this.wrapText(String.format("Got it. I've added this task:\n"
                + "  %s\nNow you have %d tasks in the list.", task, this.tasks.size()));
    }

    private String markTask(int index) {
        Task task = this.tasks.get(index - 1);
        task.markTask();
        return this.wrapText(String.format("Nice! I've marked this task as done:\n  %s", task));
    }

    private String unmarkTask(int index) {
        Task task = this.tasks.get(index - 1);
        task.unmarkTask();
        return this.wrapText(String.format("OK, I've marked this task as not done yet:\n  %s", task));
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
        return this.wrapText(taskList);
    }

    public void start() {
        boolean isExit = false;
        System.out.println(this.greet());
        while (!isExit) {
            String reply = "";
            String command = scanner.nextLine();
            String commandString = getFirstWord(command);
            String commandParams = removeFirstWord(command);
            if (commandString.equalsIgnoreCase("bye")) {
                reply = this.exit();
                isExit = true;
            } else if (commandString.equalsIgnoreCase("list")) {
                reply = this.getList();
            } else if (commandString.equalsIgnoreCase("mark")) {
                reply = this.markTask(Integer.parseInt(commandParams));
            } else if (commandString.equalsIgnoreCase("unmark")) {
                reply = this.unmarkTask(Integer.parseInt(commandParams));
            } else {
                reply = this.addToList(TaskFactory.getTask(commandString, commandParams));
            }
            System.out.println(reply);
        }
        scanner.close();
    }

    private static String getFirstWord(String userInput) {
        return userInput.trim().split("\\s+")[0];
    }

    private static String removeFirstWord(String userInput) {
        return userInput.replace(getFirstWord(userInput), "").trim();
    }
}
