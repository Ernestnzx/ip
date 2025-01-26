package amara.ui;
import java.util.ArrayList;
import java.util.Scanner;

import amara.task.Task;

public class Ui {
    private Scanner scanner;

    public Ui(String filePath) {
        this.scanner = new Scanner(System.in);
    }

    public void greet() {
        System.out.println("Hello I'm Amara\nWhat can I do for you?");
    }

    public void exit() {
        System.out.println("Bye. Hope to see you again soon! <3");
    }

    public void addToList(Task task, int listSize) {
        String message = "Got it. I've added this task:\n"
                + "  %s\nNow you have %d tasks in the list.";
        System.out.println(String.format(message, task, listSize));
    }

    public void markTask(Task task) {
        String message = "Nice! I've marked this task as done:\n  %s";
        System.out.println(String.format(message, task));
    }
    
    public void unmarkTask(Task task) {
        String message = "OK, I've marked this task as not done yet:\n  %s";
        System.out.println(String.format(message, task));
    }

    public void deleteTask(Task task, int listSize) {
        String message = "Noted. I've removed this task:\n"
                + "  %s\nNow you have %d tasks in the list.";
        System.out.println(String.format(message, task, listSize));
    }

    public void getList(ArrayList<Task> tasks) {
        // Using StringBuilder if speed is needed.
        String taskList = "Here are the tasks in your list:\n";
        int listSize = tasks.size();
        if (listSize == 0) {
            taskList += "  <You have no tasks at the moment, you may rest for now...>";
        }
        for (int i = 0; i < listSize; i++) {
            taskList += i + 1 + ". " + tasks.get(i);
            if (i < listSize - 1) {
                taskList += "\n";
            }
        }
        System.out.println(taskList);
    }

    public void findTask(ArrayList<Task> tasks) {
        // Using StringBuilder if speed is needed.
        String taskList = "Here are the matching tasks in your list:\n";
        int listSize = tasks.size();
        if (listSize == 0) {
            taskList += "  <There are no tasks that matched your query!>";
        }
        for (int i = 0; i < listSize; i++) {
            taskList += i + 1 + ". " + tasks.get(i);
            if (i < listSize - 1) {
                taskList += "\n";
            }
        }
        System.out.println(taskList);
    }


    public void printExceptionMessage(Exception e) {
        String message = e.getMessage();
        System.out.println(message);
    }

    public String readLine() {
        return this.scanner.nextLine();
    }
}
