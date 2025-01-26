import java.util.ArrayList;

public class AddToDoCommand extends Command {
    private ToDo todo;

    AddToDoCommand(ToDo todo) {
        this.todo = todo;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        tasks.add(this.todo);
        ui.addToList(todo, tasks.size());
    }
}