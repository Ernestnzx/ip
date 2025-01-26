package amara.command;
import java.util.ArrayList;

import amara.exceptions.AmaraException;
import amara.storage.Storage;
import amara.task.Task;
import amara.ui.Ui;

/**
 * A {@link Command} that deletes a {@link Task} at a specified index 
 * in the given {@code ArrayList<Task>}.
 * <p>
 * This command removes the task from the list and updates the UI 
 * with the corresponding changes.
 * </p>
 */

public class DeleteCommand extends Command {
    private final int index;

    public DeleteCommand(int index) {
        this.index = index - 1;
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
            Task task = tasks.get(this.index);
            tasks.remove(this.index);
            ui.deleteTask(task, tasks.size());
        } catch (IndexOutOfBoundsException e) {
            throw AmaraException.indexOutOfBounds();
        }
    }
}