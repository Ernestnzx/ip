package amara.command;
import java.util.ArrayList;

import amara.exceptions.AmaraException;
import amara.storage.Storage;
import amara.task.Task;
import amara.ui.Ui;

/**
 * A {@link Command} that signals the termination of the program.
 * <p>
 * Executes the necessary operations to exit, including 
 * saving the task list and triggering the exit sequence.
 * </p>
 */

public class ByeCommand extends Command {
    @Override
    public boolean isBye() {
        return true;
    }

    /**
     * Executes the {@code Command}.
     * @param tasks List of tasks.
     * @param ui UI handler.
     * @param storage To store the given List of tasks.
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws AmaraException {
        try {
            ui.exit();
            storage.saveList(tasks);
        } catch (AmaraException e) {
            throw new AmaraException("Unable to save task list :(");
        }
    }
}
