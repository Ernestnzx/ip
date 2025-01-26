import java.util.ArrayList;

public class AddEventCommand extends Command {
    private Event event;

    AddEventCommand(Event event) {
        this.event = event;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(this.event);
        ui.addToList(event, tasks.size());
    }
}