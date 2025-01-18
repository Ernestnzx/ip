import java.util.ArrayList;

public class Amara {
    private ArrayList<String> tasks;

    private static final String BOARDER = "_".repeat(60);

    Amara() {
        this.tasks = new ArrayList<String>();
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

    String addToList(String task) {
        this.tasks.add(task);
        return this.wrapText(String.format("added: %s", task));
    }

    String getList() {
        // Using StringBuilder if speed is needed.
        String taskList = "";
        int listSize = this.tasks.size();
        for (int i = 0; i < listSize; i++) {
            taskList += i + 1 + ". " + this.tasks.get(i);
            if (i < listSize - 1) {
                taskList += "\n";
            }
        }
        return this.wrapText(taskList);
    }
}
