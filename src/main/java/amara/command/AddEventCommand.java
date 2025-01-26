package amara.command;
import java.util.ArrayList;

import amara.storage.Storage;
import amara.task.Event;
import amara.task.Task;
import amara.ui.Ui;

public class AddEventCommand extends Command {
    private Event event;

    public AddEventCommand(Event event) {
        this.event = event;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(this.event);
        ui.addToList(event, tasks.size());
    }
}