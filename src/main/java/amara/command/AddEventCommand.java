package amara.command;

import java.util.ArrayList;

import amara.storage.Storage;
import amara.task.Deadline;
import amara.task.Event;
import amara.task.Task;
import amara.ui.Ui;

/**
 * A {@link Command} implementation that adds a {@link Deadline} task 
 * to a given {@code ArrayList<Task>}.
 * <p>
 * The given {@link Event} task is added to the provided {@code ArrayList<Task>}.
 * </p>
 */
public class AddEventCommand extends Command {
    private Event event;
    private static final String MESSAGE = "Got it. I've added this task:\n"
            + "  %s\nNow you have %d tasks in the list.";

    public AddEventCommand(Event event) {
        this.event = event;
    }

    /**
     * Executes the {@code Command}.
     * @param tasks List of tasks.
     * @param ui UI handler.
     * @param storage To store the given List of tasks.
     */
    @Override
    public String execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(this.event);
        String string = String.format(AddEventCommand.MESSAGE, this.event, tasks.size());
        ui.display(string);
        return string;
    }
}