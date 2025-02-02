package amara.command;

import java.util.ArrayList;

import amara.exceptions.AmaraException;
import amara.storage.Storage;
import amara.task.Task;
import amara.ui.Ui;

/**
 * A {@link Command} that finds all {@link Task} with a query string
 * in the given {@code ArrayList<Task>}.
 * <p>
 * This command removes the task from the list and updates the UI
 * with the corresponding changes.
 * </p>
 */
public class FindCommand extends Command {
    private final String query;

    public FindCommand(String query) {
        this.query = query;
    }

    /**
     * Executes the {@code Command}.
     * @param tasks List of tasks.
     * @param ui UI handler.
     * @param storage To store the given List of tasks.
     */
    @Override
    public String execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws AmaraException {
        ArrayList<Task> queries = new ArrayList<Task>();
        for (Task task : tasks) {
            if (task.getTaskDescription().contains(this.query)) {
                queries.add(task);
            }
        }
        String taskList = "Here are the matching tasks in your list:\n";
        int listSize = queries.size();
        if (listSize == 0) {
            taskList += "  <There are no tasks that matched your query!>";
        }
        for (int i = 0; i < listSize; i++) {
            taskList += i + 1 + ". " + queries.get(i);
            if (i < listSize - 1) {
                taskList += "\n";
            }
        }
        ui.display(taskList);
        return taskList;
    }
}
