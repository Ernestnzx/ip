package amara.command;
import java.util.ArrayList;

import amara.storage.Storage;
import amara.task.Task;
import amara.ui.Ui;

public class ListCommand extends Command {
    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        ui.getList(tasks);
    }
}
