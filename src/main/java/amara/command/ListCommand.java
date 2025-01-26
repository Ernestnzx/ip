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
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        ui.getList(tasks);
    }
}
