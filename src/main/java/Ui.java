import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    private String commandText;
    private Scanner scanner;
    private static final String BOARDER = "=".repeat(70);

    Ui(String filePath) {
        this.commandText = "";
        this.scanner = new Scanner(System.in);
    }

    private String wrapText(String text) {
        return String.format("%s\n%s\n%s", Ui.BOARDER, text, Ui.BOARDER);
    }

    public void greet() {
        System.out.println(this.wrapText("Hello I'm Amara\nWhat can I do for you?"));
    }

    public void exit() {
        System.out.println(this.wrapText("Bye. Hope to see you again soon! <3"));
    }

    public void addToList(Task task, int listSize) {
        String message = this.wrapText("Got it. I've added this task:\n"
                + "  %s\nNow you have %d tasks in the list.");
        System.out.println(String.format(message, task, listSize));
    }

    public void markTask(Task task) {
        String message = this.wrapText("Nice! I've marked this task as done:\n  %s");
        System.out.println(String.format(message, task));
    }
    
    public void unmarkTask(Task task) {
        String message = this.wrapText("OK, I've marked this task as not done yet:\n  %s");
        System.out.println(String.format(message, task));
    }

    public void deleteTask(Task task, int listSize) {
        String message = this.wrapText("Noted. I've removed this task:\n"
            + "  %s\nNow you have %d tasks in the list.");
            System.out.println(String.format(message, task, listSize));
    }

    public void getList(ArrayList<Task> tasks) {
        // Using StringBuilder if speed is needed.
        String taskList = "Here are the tasks in your list:\n";
        int listSize = tasks.size();
        if (listSize == 0) {
            taskList += "<You have no tasks, you may rest for now...>";
        }
        for (int i = 0; i < listSize; i++) {
            taskList += i + 1 + ". " + tasks.get(i);
            if (i < listSize - 1) {
                taskList += "\n";
            }
        }
        System.out.println(this.wrapText(taskList));
    }

    public void printExceptionMessage(Exception e) {
        String message = this.wrapText(e.getMessage());
        System.out.println(message);
    }

    public void updateCommandText(String commandText) {
        this.commandText = commandText;
    }

    public void printCommandText() {
        System.out.println(this.commandText);
    }

    public String readLine() {
        return this.scanner.nextLine();
    }
}
