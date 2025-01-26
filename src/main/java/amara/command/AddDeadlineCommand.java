package amara.command;

import java.util.ArrayList;

import amara.storage.Storage;
import amara.task.Deadline;
import amara.task.Task;
import amara.ui.Ui;

public class AddDeadlineCommand extends Command {
    private Deadline deadline;

    public AddDeadlineCommand(Deadline deadline) {
        this.deadline = deadline;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(this.deadline);
        ui.addToList(deadline, tasks.size());
    }
}