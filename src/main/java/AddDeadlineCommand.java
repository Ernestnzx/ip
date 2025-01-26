import java.util.ArrayList;

public class AddDeadlineCommand extends Command {
    private Deadline deadline;

    AddDeadlineCommand (Deadline deadline) {
        this.deadline = deadline;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(this.deadline);
        ui.addToList(deadline, tasks.size());
    }
}