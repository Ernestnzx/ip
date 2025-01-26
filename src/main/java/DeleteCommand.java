import java.util.ArrayList;

public class DeleteCommand extends Command {
    private final int index;

    DeleteCommand(int index) {
        this.index = index - 1;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws AmaraException {
        try {
            Task task = tasks.get(this.index);
            tasks.remove(this.index);
            ui.deleteTask(task, tasks.size());
        } catch (IndexOutOfBoundsException e) {
            throw AmaraException.indexOutOfBounds();
        }
    }
}