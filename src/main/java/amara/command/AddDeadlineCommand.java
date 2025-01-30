package amara.command;

import java.util.ArrayList;

import amara.storage.Storage;
import amara.task.Deadline;
import amara.task.Task;
import amara.ui.Ui;

/**
 * A {@link Command} implementation that adds a {@link Deadline} task 
 * to a given {@code ArrayList<Task>}.
 * <p>
 * The given {@link Deadline} task is  added to the provided {@code ArrayList<Task>}.
 * </p>
 */
public class AddDeadlineCommand extends Command {
    private Deadline deadline;
    private static final String MESSAGE = "Got it. I've added this task:\n"
            + "  %s\nNow you have %d tasks in the list.";

    public AddDeadlineCommand(Deadline deadline) {
        this.deadline = deadline;
    }

    /**
     * Executes the {@code Command}.
     * @param tasks List of tasks.
     * @param ui UI handler.
     * @param storage To store the given List of tasks.
     */
    @Override
    public String execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(this.deadline);
        String string = String.format(AddDeadlineCommand.MESSAGE, this.deadline, tasks.size());
        ui.display(string);
        return string;
    }
}