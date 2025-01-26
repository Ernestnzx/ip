import java.util.ArrayList;

public abstract class Command {
    public boolean isBye() {
        return false;
    }

    public abstract void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws AmaraException ;
}
