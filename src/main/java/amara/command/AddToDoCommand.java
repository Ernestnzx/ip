package amara.command;
import java.util.ArrayList;

import amara.storage.Storage;
import amara.task.Deadline;
import amara.task.Task;
import amara.task.ToDo;
import amara.ui.Ui;
 
/**
 * A {@link Command} implementation that adds a {@link Deadline} task 
 * to a given {@code ArrayList<Task>}.
 * <p>
 * The given {@link ToDo} task is  added to the provided {@code ArrayList<Task>}.
 * </p>
 */
public class AddToDoCommand extends Command {
    private ToDo todo;

    public AddToDoCommand(ToDo todo) {
        this.todo = todo;
    }

    /**
     * Executes the {@code Command}.
     * @param tasks List of tasks.
     * @param ui UI handler.
     * @param storage To store the given List of tasks.
     */
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(this.todo);
        ui.addToList(todo, tasks.size());
    }
}