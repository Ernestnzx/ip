package amara.command;

import java.util.ArrayList;
import java.util.stream.IntStream;

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
        String header = "Here are the tasks in your list:\n";
        String taskList = IntStream
                .range(0, tasks.size())
                .mapToObj(x -> String.format("%d.) %s", x + 1, tasks.get(x).toString()))
                .reduce((x, y) -> x + '\n' + y)
                .orElse("  <You have no tasks at the moment, you may rest for now...>");
        String formattedTaskList = header + taskList;
        ui.display(formattedTaskList);
        return formattedTaskList;
    }
}
