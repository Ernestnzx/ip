import java.util.ArrayList;

public class ByeCommand extends Command {
    @Override
    public boolean isBye() {
        return true;
    }

    @Override
    public void execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        try {
            ui.exit();
            storage.saveList(tasks);
        } catch (AmaraException e) {
            System.out.println("Unable to save task list :(");
        }
    }
}
