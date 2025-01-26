package amara.command;

import java.util.ArrayList;

import amara.exceptions.AmaraException;
import amara.storage.Storage;
import amara.task.Task;
import amara.ui.Ui;

public class FindCommand extends Command {
    private final String query;

    public FindCommand(String query) {
        this.query = query;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws AmaraException {
        ArrayList<Task> queries = new ArrayList<Task>();
        for (Task task : tasks) {
            if (task.getTaskDescription().contains(this.query)) {
                queries.add(task);
            }
        }
        ui.findTask(queries);
    }
}
