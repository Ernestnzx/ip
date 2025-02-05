package amara.command;

import java.util.ArrayList;

import amara.exceptions.AmaraException;
import amara.storage.Storage;
import amara.task.Task;
import amara.ui.Ui;

/**
 * A {@link Command} that unmarks a {@link Task} as incomplete
 * at a specific index in the given {@code ArrayList<Task>}.
 * <p>
 * This command retrieves the task, marks it as incomplete,
 * and updates the {@link Ui} accordingly.
 * </p>
 */
public class UnmarkCommand extends Command {
    private static final String MESSAGE = "OK, I've marked this task as not done yet:\n  %s";
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index - 1;
    }

    /**
     * Executes the {@code Command}.
     * @param tasks List of tasks.
     * @param ui UI handler.
     * @param storage To store the given List of tasks.
     */
    @Override
    public String execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws AmaraException {
        try {
            Task task = tasks.get(this.index);
            task.unmarkTask();
            String message = String.format(UnmarkCommand.MESSAGE, task);
            ui.display(message);
            return message;
        } catch (IndexOutOfBoundsException e) {
            throw AmaraException.indexOutOfBounds();
        }
    }
}
