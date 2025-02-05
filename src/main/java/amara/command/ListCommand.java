package amara.command;

import java.util.ArrayList;

import amara.storage.Storage;
import amara.task.Task;
import amara.ui.Ui;

/**
 * A {@link Command} that displays the list of tasks in the given {@code ArrayList<Task>}.
 * <p>
 * This command interacts with the {@link Ui} to display all tasks to the user.
 * </p>
 */
public class ListCommand extends Command {
    /**
     * Executes the {@code Command}.
     * @param tasks List of tasks.
     * @param ui UI handler.
     * @param storage To store the given List of tasks.
     */
    @Override
    public String execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        // Using StringBuilder if speed is needed.
        String taskList = "Here are the tasks in your list:\n";
        if (tasks.isEmpty()) {
            taskList += "  <You have no tasks at the moment, you may rest for now...>";
        } else {
            int listSize = tasks.size();
            for (int i = 0; i < listSize; i++) {
                taskList += i + 1 + ". " + tasks.get(i);
                if (i < listSize - 1) {
                    taskList += "\n";
                }
            }
        }
        ui.display(taskList);
        return taskList;
    }
}
