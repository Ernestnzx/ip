package amara.command;

import java.util.ArrayList;
import java.util.stream.IntStream;

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
        String header = "Here are the matching tasks in your list:\n";
        String taskList = IntStream
                .range(0, tasks.size())
                .filter(x -> tasks.get(x).getTaskDescription().contains(this.query))
                .mapToObj(x -> String.format("%d.) %s", x + 1, tasks.get(x).toString()))
                .reduce((x, y) -> x + '\n' + y)
                .orElse("  <There are no tasks that matched your query> :(");
        String formattedTaskList = header + taskList;
        ui.display(formattedTaskList);
        return formattedTaskList;
    }
}
