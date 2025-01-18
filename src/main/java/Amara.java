import java.util.ArrayList;

public class Amara {
    private ArrayList<Task> tasks;

    private static final String BOARDER = "_".repeat(60);

    Amara() {
        this.tasks = new ArrayList<Task>();
    }

    private String wrapText(String text) {
        return String.format("%s\n%s\n%s", Amara.BOARDER, text, Amara.BOARDER);
    }

    String greet() {
        return this.wrapText("Hello I'm Amara\nWhat can I do for you?");
    }

    String exit() {
        return this.wrapText("Bye. Hope to see you again soon!");
    }

    String echo(String sentence) {
        return this.wrapText(sentence);
    }

    String addToList(String taskDescription) {
        this.tasks.add(new Task(taskDescription));
        return this.wrapText(String.format("added: %s", taskDescription));
    }

    String markTask(int index) {
        Task task = this.tasks.get(index - 1);
        task.markTask();
        return this.wrapText(String.format("Nice! I've marked this task as done:\n  [x] %s", task.getDescription()));
    }

    String unmarkTask(int index) {
        Task task = this.tasks.get(index - 1);
        task.unmarkTask();
        return this.wrapText(String.format("OK, I've marked this taskas not done yet:\n  [ ] %s", task.getDescription()));
    }

    String getList() {
        // Using StringBuilder if speed is needed.
        String taskList = "Here are the tasks in your list:\n";
        int listSize = this.tasks.size();
        for (int i = 0; i < listSize; i++) {
            boolean status = this.tasks.get(i).getStatus();
            String taskDescription = this.tasks.get(i).getDescription();
            taskList += i + 1 + ". [" + (status ? "X" : " ") + "] " + taskDescription;
            if (i < listSize - 1) {
                taskList += "\n";
            }
        }
        return this.wrapText(taskList);
    }
}
