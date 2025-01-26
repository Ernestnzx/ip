import java.util.ArrayList;

public class UnmarkCommand extends Command {
    private final int index;

    UnmarkCommand(int index) {
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