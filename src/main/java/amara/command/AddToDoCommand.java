package amara.command;
import java.util.ArrayList;

import amara.storage.Storage;
import amara.task.Task;
import amara.task.ToDo;
import amara.ui.Ui;

public class AddToDoCommand extends Command {
    private ToDo todo;

    public AddToDoCommand(ToDo todo) {
        this.todo = todo;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(this.todo);
        ui.addToList(todo, tasks.size());
    }
}