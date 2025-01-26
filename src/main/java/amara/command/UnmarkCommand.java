package amara.command;

import java.util.ArrayList;

import amara.exceptions.AmaraException;
import amara.storage.Storage;
import amara.task.Task;
import amara.ui.Ui;

public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index - 1;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws AmaraException {
        try {
            Task task = tasks.get(this.index);
            task.unmarkTask();
            ui.unmarkTask(task);
        } catch (IndexOutOfBoundsException e) {
            throw AmaraException.indexOutOfBounds();
        }
    }
}