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
        ArrayList<String> queries = new ArrayList<String>();
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getTaskDescription().contains(this.query)) {
                queries.add(i + 1 + ". " + task);
            }
        }
        String taskList = "Here are the matching tasks in your list:\n";
        if (queries.isEmpty()) {
            taskList += "  <There are no tasks that matched your query!>";
        } else {
            int listSize = queries.size();
            for (int i = 0; i < listSize; i++) {
                taskList += queries.get(i);
                if (i < listSize - 1) {
                    taskList += "\n";
                }
            }
        }
        ui.display(taskList);
        return taskList;
    }
}
